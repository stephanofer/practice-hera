# Practice Hera — Hoja de Ruta de Desarrollo

## Objetivo

Construir el sistema de Practice en piezas chicas, componibles y estables, de forma que cada fase deje una base sólida para la siguiente. La meta es evitar caos de dependencias, reducir retrabajo y hacer que hub, match, FFA y proxy nazcan sobre un modelo de dominio compartido en vez de código improvisado dentro de plugins.

---

## Principios de desarrollo

1. **Base antes que features**
   - No arrancamos por lo visible.
   - Primero definimos contratos, modelo de estado e infraestructura.
   - **Por qué**: si esta base está floja, todo lo de arriba queda acoplado y frágil.

2. **Las reglas de negocio viven en módulos compartidos**
   - `practice-api` = contratos y tipos compartidos.
   - `practice-core` = reglas de negocio y casos de uso.
   - `practice-data` = implementaciones MySQL/Redis.
   - Los plugins runtime solo adaptan eventos de plataforma, UX e integración.

3. **Cada fase tiene que destrabar la siguiente**
   - Una fase solo es válida si reduce incertidumbre futura.
   - Si algo va a ser reutilizado por 2 o más runtimes, se resuelve antes que una feature específica.

4. **No se empieza una feature sin prerequisitos**
   - Antes de implementar una feature, hay que definir:
     - prerequisitos de dominio
     - prerequisitos de persistencia
     - prerequisitos de estado distribuido
     - prerequisitos de UX/runtime
   - Si falta algo, se pausa la feature y se resuelve esa base primero.

---

## Orden global de construcción

Vamos a desarrollar en este orden:

1. **Fundamentos de negocio y dominio**
2. **Fundamentos de datos e infraestructura**
3. **Servicios de aplicación compartidos**
4. **Flujo principal del Hub**
5. **Ciclo de vida de Match**
6. **Ciclo de vida de FFA**
7. **Orquestación del Proxy**
8. **Hardening, observabilidad y pulido**

Esto es INTENCIONAL. El proyecto no son “4 plugins separados”. Es **un dominio con varios runtimes**.

---

## Fase 0 — Definir el lenguaje del negocio

### Objetivo
Establecer los conceptos base del negocio antes de diseñar sistemas alrededor.

### Entregables
- glosario de conceptos del negocio
- responsabilidades por runtime
- inventario inicial de funcionalidades
- invariantes y reglas base

### Se define acá
- perfil de jugador
- tipos de cola
- kits
- arena
- match
- estados y transiciones
- sesión/estado de FFA
- alcance del elo/rating
- alcance de temporadas
- punishments, cooldowns y locks

### Por qué va primero
Porque arrancar escribiendo clases sin entender el negocio es EXACTAMENTE como se arruina una arquitectura.

---

## Fase 1 — Contratos compartidos y modelo de dominio

### Objetivo
Crear el modelo estable compartido entre `practice-api` y `practice-core`.

### Se construye acá
- identificadores y value objects
- enums de modos, estados y conceptos de plataforma
- interfaces de servicios de dominio
- servicios orientados a casos de uso
- reglas core de validación y elegibilidad
- eventos de dominio que valga la pena modelar

### Ejemplos
- elegibilidad para cola
- reglas de selección de kit
- precondiciones para crear match
- reglas de disponibilidad de arenas
- restricciones de estado del jugador

### Criterio de salida
- las reglas de negocio importantes se pueden testear sin Paper ni Velocity
- los runtimes dependen de contratos, no de supuestos escondidos

---

## Fase 2 — Persistencia y hot state

### Objetivo
Definir qué vive en MySQL y qué vive en Redis ANTES de programar gameplay serio.

### Se construye acá
- repositorios/gateways
- modelos de persistencia y mappings
- diseño de claves/estructuras de Redis
- estrategia de caché
- estrategia de locks/cooldowns
- bootstrap/config de infraestructura

### Hay que decidir acá
- source of truth por entidad
- qué se cachea
- qué debe ser atómico
- qué debe sobrevivir reinicios
- qué puede reconstruirse

### Criterio de salida
- cada entidad importante tiene dueño claro de persistencia
- ninguna feature runtime necesita “inventarse storage” después

---

## Fase 3 — Servicios de aplicación compartidos

### Objetivo
Crear servicios reutilizables que orquesten dominio + datos.

### Se construye acá
- profile service
- queue service
- matchmaking service
- arena allocation service
- match registry service
- server presence service
- leaderboard projection service

### Regla
Si hub, match, FFA o proxy necesitan la misma decisión, esa lógica va acá y NO duplicada por plugin.

### Criterio de salida
- los workflows principales pueden describirse como llamadas a servicios
- los runtimes solo adaptan eventos de plataforma a esos servicios

---

## Fase 4 — Primer vertical slice utilizable del Hub

### Objetivo
Hacer del Hub el primer runtime visible porque es la puerta de entrada al sistema.

### Se construye acá
- bootstrap al entrar
- carga de perfil / registro de presencia
- entry points de colas
- scoreboards/tab/chat básicos
- flujo join/leave de cola
- feedback y errores al usuario

### No se construye todavía
- cosméticos avanzados
- menús complejos innecesarios
- polish no esencial

### Por qué antes que Match
Porque el Hub define cómo entra el jugador al sistema. Si esa entrada está mal pensada, todo lo demás se ensucia.

---

## Fase 5 — Dominio y runtime de Match

### Objetivo
Construir el ciclo completo del duelo solo cuando ya existan colas, perfil y servicio de arenas.

### Se construye acá
- creación del match
- transferencia al runtime de match
- reserva/liberación de arena
- aplicación de kit
- countdown / start / end
- persistencia de resultados
- cleanup post-match

### Dependencias
- queue service
- arena service
- player state model
- result persistence

### Por qué acá
Match es uno de los sistemas más cargados de estado. Tiene que montarse sobre servicios ya estables.

---

## Fase 6 — Runtime de FFA

### Objetivo
Implementar FFA cuando ya existan conceptos compartidos de combate y estado de jugador.

### Se construye acá
- spawn/respawn
- tracking de estado de combate
- kills/deaths/streaks
- datos básicos de scoreboard
- hooks de recompensa/progresión si aplican

### Reutilización esperada
- profile service
- restricciones de estado/presencia
- lógica de kits si corresponde
- patrones de leaderboard

### Por qué después de Match
FFA tiene menos orquestación que ranked match, pero se beneficia de la misma base de estados y estadísticas.

---

## Fase 7 — Orquestación del Proxy

### Objetivo
Mantener el proxy fino y enfocado en routing.

### Se construye acá
- fallback routing
- transfer orchestration
- resolución de destino
- recovery ante fallos de transfer
- integraciones bootstrap del proxy

### No debe tener
- elo
- reglas de match
- persistencia de negocio

### Por qué más tarde
El proxy depende de que el resto de runtimes ya sepan a dónde debe ir cada jugador y por qué.

---

## Fase 8 — Hardening y readiness de producción

### Objetivo
Endurecer y estabilizar todo lo construido.

### Se construye acá
- logs y diagnóstico operacional
- comandos admin/debug
- recovery flows
- timeouts y manejo de fallos
- validación de config
- expansión de tests
- revisión de performance en hot paths

### Por qué al final
Pulir algo inestable da sensación de progreso, pero no progreso real.

---

## Reglas de trabajo para evitar retrabajo

### Regla 1 — Negocio primero, UX después
Si un menú, botón o comando necesita lógica que todavía no existe en core, se frena y se define primero en core.

### Regla 2 — La dependencia compartida gana prioridad
Si la feature A depende de la feature B, y B además la usan varios módulos, B va primero.

### Regla 3 — Vertical slices sí, pero sobre base real
Podemos construir slices visibles, pero solo sobre prerequisitos de dominio y datos ya resueltos.

### Regla 4 — Si aparece una dependencia escondida, se pausa
No se parchea por apuro. Se crea la pieza base faltante y recién después se retoma.

### Regla 5 — Toda feature debe declarar prerequisitos
Antes de empezar una feature, hay que listar:
- prerequisitos de dominio
- prerequisitos de datos
- prerequisitos de runtime
- estrategia de test

---

## Secuencia práctica sugerida

1. Escribir glosario del negocio e inventario de features
2. Definir modelo de estado del jugador e identificadores/value objects base
3. Definir contratos de cola, kit, arena y match
4. Definir interfaces de repositorios/gateways
5. Diseñar límites MySQL vs Redis
6. Construir profile service y queue service
7. Construir flujo de entrada al hub + entrada/salida de cola
8. Construir matchmaking + arena allocation
9. Construir lifecycle de match
10. Construir lifecycle de FFA
11. Construir transfer orchestration del proxy
12. Agregar diagnóstico, herramientas admin y hardening

---

## Qué tenemos que ir definiendo en paralelo

Aunque no se implemente todavía, hay que ir refinando:

- modos de juego soportados por Practice
- tipos de cola y sus reglas
- modelo de ranking
- estructura de temporadas
- restricciones/punishments
- comportamiento social/parties si aplica
- estrategia de leaderboards
- alcance de historial de matches
- capacidades admin/moderación

**Por qué**: así evitamos diseñar una solución local que después explota cuando aparece otra regla de negocio.

---

## Siguiente paso inmediato

El primer artefacto correcto NO es código.

Lo siguiente que tenemos que hacer es definir el **glosario del negocio + inventario de funcionalidades + invariantes core**. Esa es la base para specs, diseño e implementación sin cambiar el foco a cada rato.
