# Practice Hera — Fase 0: Definición Inicial del Producto

## Nota

Este documento captura, sin omitir ideas funcionales importantes, la visión inicial expresada para el producto Practice de Hera. Esto es una base viva: se va a seguir refinando fase por fase.

---

## Identidad inicial del producto

Practice NO va a ser un simple practice mínimo.

Va a ser un sistema competitivo PvP muy fuerte, con corazón en:

- **Ranked**
- **Unranked**
- **matchmaking impecable**
- **SR (Skill Rating) + rangos**
- **leaderboards y clasificaciones**
- **múltiples kits y modos**
- **múltiples arenas**
- **warmup sólido**

Pero además va a expandirse a un ecosistema PvP/social más grande con:

- **FFA**
- **parties**
- **party duels**
- **historial de partidas**
- **perfiles públicos**
- **progresión social**
- **eventos hosteados por jugadores con rango**
- **friends**
- **settings avanzados por usuario**

---

## Núcleo competitivo

### Ranked y Unranked

El producto va a tener:

- colas **Ranked**
- colas **Unranked**

### Lógica de rondas

Los matches pueden tener lógica de rondas.

Ejemplo:

- mejor de 3
- mejor de X rondas según modo o kit

Importante:

- no todas las partidas necesariamente tienen que funcionar igual
- según el modo o el kit, el formato puede cambiar

Esto implica que el dominio de match debe contemplar desde el inicio:

- formatos de serie
- conteo de rondas ganadas
- condición de victoria por serie
- variantes por modo o kit

---

## Rating competitivo: SR + rangos

El sistema de rating es **ULTRA importante**.

La definición actual es usar:

- **SR (Skill Rating)**
- **rangos visibles según tu SR**
- **Global Rating**

### SR por modo

Se definió que:

- cada modo tiene su propio **SR independiente**
- el SR sube al ganar
- el SR baja al perder

Esto significa que el skill competitivo se mide por ladder/modo, no con un único valor mezclado para todo.

### Global Rating

Además va a existir un **Global Rating**.

La definición actual es:

- el **promedio simple** de todos los SR por modo del jugador

Ejemplo dado:

- Sword: 1,845
- Axe: 1,916
- UHC: 2,195
- Vanilla: 1,306
- Mace: 2,059
- Pot: 1,888
- NetheriteOP: 1,729
- SMP: 1,689
- DiamondSMP: 1,871

Total:

- 16,498 / 9 modos = **1,833 Global Rating**

Ejemplos mencionados:

- **Unranked / recién empieza** → ejemplo como Vendimia con **798**
- **Diamond III** → rango medio-alto, aprox. **2046–2166 SR**
- **Netherite** → casi top, aprox. **2264 SR**
- **Grandmaster** → rango más alto visible, ejemplo **#1 Verniq con 2300 SR**

Esto sugiere desde el negocio:

- rank tiers visibles
- thresholds por rango
- leaderboard global y por modo
- ranking competitivo como parte central de la retención

### Rangos por modo y rango global

También se definió que existirán:

- **SR por modo**
- **rango por modo**
- **Global Rating**
- **rango global**

Ejemplo preliminar de mapeo por SR:

- Emerald → ~1000 - 1499
- Diamond → ~1500 - 1999
- Netherite → 2000+

OJO: estos nombres e intervalos son ejemplos iniciales. Después se definirán exactamente.

### Seasons

Se definió que:

- **sí habrá seasons desde esta primera gran fase**

Pero con una filosofía SIMPLE.

### Enfoque de seasons

La intención NO es construir un sistema ultra automatizado y complejo desde el principio.

Lo importante es:

- que exista el concepto de corte de season
- que se conserven los datos históricos
- que el sistema quede preparado para manejar seasons

### Definiciones actuales

- la duración puede variar
- el cierre de season puede ser **manual**
- no se quiere depender de que automáticamente, al llegar una fecha, “se corte todo”
- lo importante es poder ejecutar el corte de forma controlada y mantener histórico

### Reset de season

La opción más simple y aceptada por ahora es:

- **reset total**

### Histórico

Se quiere conservar:

- datos por season
- datos **all-time**

### Rewards

Los rewards se darán:

- **manualmente**

### Global Rating en contexto de seasons

Se quiere contemplar ambos:

- **seasonal**
- **histórico / all-time**

### Recomendación inicial sobre placements, decay y streaks

Como el objetivo es un Practice competitivo, la recomendación inicial es:

- **placements iniciales: sí**
- **decay: no al inicio**
- **streak bonus para SR: no al inicio**

#### Por qué

- **placements sí**: ayudan a ubicar más rápido a jugadores nuevos y reducen basura competitiva en los primeros matches
- **decay no al inicio**: agrega complejidad operativa y presión artificial antes de validar bien el sistema principal
- **streak bonus no al inicio**: puede distorsionar demasiado la calidad competitiva; es mejor que el SR refleje dificultad del rival y resultado real antes que rachas infladas

Más adelante esto se puede ajustar sin romper el modelo base.

---

## Historial de partidas y detalle post-match

Sí va a existir historial de partidas.

### Idea principal

Cuando comienza un match, durante el combate se recopila mucha información. Al terminar, se mostrará un enlace en el chat con la información del combate.

Ese enlace puede no estar disponible instantáneamente. Se puede generar por detrás y aparecer unos segundos después, cuando ya esté listo.

### Información ejemplo a mostrar por jugador

Ejemplo de estadísticas como las mencionadas:

- Health
- Hits
- Longest Combo
- Heals Used
- Pot Accuracy
- Crits
- Dmg Dealt
- Dmg Taken
- Ping

Ejemplo textual dado:

#### parrottitan
- Health: 3.0 ❤
- Hits: 20
- Longest Combo: 2
- Heals Used: 0
- Pot Accuracy: 0%
- Crits: 6
- Dmg Dealt: 20.5
- Dmg Taken: 13.6
- Ping: 18ms

### También debe mostrar

- espada restante
- armadura restante
- totems restantes
- items restantes
- inventario/equipamiento relevante de ambos jugadores

### Representación exacta del inventario

También se quiere contemplar que el inventario del jugador pueda guardarse o representarse con suficiente fidelidad como para mostrarlo en web **exactamente en los slots correspondientes**.

Esto es importante para:

- mostrar el estado final real del jugador
- visualizar hotbar/layout como terminó la pelea
- representar armadura, offhand, consumibles y items restantes con precisión

La intención actual es guardar lo realmente importante, sin volver esto excesivo, pero sí dejando el modelo listo para reflejar el inventario con exactitud visual.

### Decisión actual sobre snapshot de inventario

Se definió que:

- se guardará **solo el snapshot final del inventario**
- no hace falta guardar un snapshot inicial separado del loadout para esta primera gran fase

---

## Estructura objetivo del historial de match

Se definió que el historial/resumen del match debe contemplar estos 4 grupos de datos:

### 1. Metadata del match

Debe contemplar, al menos:

- match id
- tipo de match
- modo/ladder
- ranked o unranked
- formato (bo1, bo3, etc.)
- mapa/arena
- región
- timestamps relevantes
- duración
- ganador
- server id o referencia operativa similar

### 2. Datos por jugador

Debe contemplar, al menos:

- uuid
- nombre
- team/side si aplica
- SR antes y después
- resultado
- ping promedio o final
- health/hearts finales
- inventario final
- armor final
- efectos activos si aplica
- consumibles restantes

### 3. Stats agregadas

Debe contemplar, al menos:

- hits landed
- hits received
- combo máximo
- crits
- damage dealt
- damage taken
- pots lanzadas
- pots acertadas
- heals used
- pearls used
- gaps usadas
- totems popped
- blocks placed
- blocks broken

### 4. Eventos mínimos importantes

No se busca una replay completa, pero sí eventos mínimos con valor real.

Debe contemplar eventos como:

- round start/end
- death
- kill o determinación de ganador si aplica
- void/lava/water death
- potion use relevante si aplica
- pearl throw relevante si aplica
- totem pop si aplica
- pressure plate instant win u otra condición especial equivalente

### Criterio general

- sí guardar lo importante
- no guardar una timeline absurda o excesiva en esta primera gran fase
- priorizar resumen potente, consistente y representable en juego/web

### Información global del match

- mapa
- duración
- ladder / kit
- región

Ejemplo mencionado:

- Map: Sea
- Duration: 00:31
- Ladder: Sword
- Region: North America

### Adicionalmente

Dentro del juego también va a haber menús con historial de peleas del jugador.

---

## Arenas

Sí, va a haber:

- múltiples arenas

Esto probablemente implique más adelante:

- pool de arenas por modo/kit
- disponibilidad
- selección automática o ponderada
- administración de arena occupancy

---

## Modos y kits

Sí, va a haber:

- múltiples modos
- diferentes kits

También se mencionó explícitamente que el usuario va a poder editar sus kits/layouts.

### Decisión clave: sistema flexible de modos base

Acá hay una decisión de arquitectura MUY importante.

No queremos diseñar los modos como lógica rígida hardcodeada para cada ladder desde el principio.

La idea es separar:

1. **Modos base configurables**
2. **Modos especiales con comportamiento propio**

### 1. Modos base configurables

Estos son modos que pueden construirse a partir de una estructura común y configuración declarativa.

Al crear un modo base, se quiere poder definir al menos:

- `identifier`
- `display name`
- `player types` habilitados
  - 1v1
  - 2v2
  - 3v3
  - 4v4
  - FFA de party
  - FFA público
- `premade kit`
- `menu item`
- `match settings`
  - default rounds to win
  - pre-fight delay
  - duración máxima del match

Esto significa que muchos modos deberían nacer como una combinación de:

- metadata del modo
- kit base
- settings del match
- conjunto de rules

### 2. Modos especiales con comportamiento propio

Algunos modos sí tienen comportamiento demasiado particular y probablemente necesiten lógica específica.

Ejemplos claros:

- Sumo
- Boxing
- Bridge
- Dropped

La meta es que estos casos especiales existan, pero que el sistema esté diseñado para que la mayoría de modos no requieran una implementación completamente nueva.

---

## Sistema de Rules configurables

Esto se definió como un concepto muy poderoso y central para el diseño de modos.

La idea es manejar un sistema de **rules configurables** que alteren el comportamiento del match/modo sin tener que crear un modo nuevo desde cero cada vez.

### Catálogo inicial oficial de rules

Verificado: las **rules iniciales** serán exactamente esta lista base que definiste. No la tomo como “ejemplos sueltos”, sino como el primer catálogo oficial sobre el que vamos a diseñar el Rule System.

- Hunger does not go down
- Disable break/place blocks
- Dying by touching lava
- Timed block
- Golden Apple cooldown
- Only arrow damage
- No fall damage
- Soup restores health
- God apple cooldown
- Dying by touching water
- Dying by touching void
- Water slowly damage
- Arrows disappear on ground
- Only self-placed block breaking
- Ender pearl cooldown
- Immune to losing health
- Disable Elytra
- Disable Totem
- Golden head insta consumable, gives a golden apple effect
- Disable crafting slots
- Health does not regenerate
- Disable item drop
- Pressure plate instant win
- Extra hearts
- No hit delay
- Potion effects
- Remove empty bottle
- Disable ender pearl

### Nota importante

Este catálogo inicial es considerable y suficiente para diseñar el sistema correctamente desde el principio.

Más adelante podremos:

- agregar nuevas rules
- eliminar alguna si deja de tener sentido
- ajustar parámetros o compatibilidades

Pero la base inicial validada es esta lista exacta.

### Implicación arquitectónica

Esto empuja el diseño hacia algo así:

- un **Mode Definition**
- un **Match Settings Definition**
- un **Rule Set**
- handlers/evaluadores de reglas enchufables

Y NO hacia un sistema donde cada ladder sea una clase gigante con lógica mezclada.

### Beneficio principal

Poder crear muchos modos nuevos simplemente configurando:

- identidad
- kit
- settings
- rules

Y reservar código especial solo para ladders verdaderamente excepcionales.

---

## Tipos de enfrentamiento y relación con los modos

### Player types

Se definió que los **player types son configurables por modo**.

Eso significa que un modo puede declarar cuáles variantes soporta, por ejemplo:

- 1v1
- 2v2
- 3v3
- 4v4
- FFA de party
- FFA público

Importante: el modo no está obligado a soportar todos.
Cada modo habilita solo los tipos que tengan sentido.

### Ranked

Se definió explícitamente que:

- **Ranked será solo 1v1**

Eso simplifica muchísimo el sistema competitivo principal, porque:

- el SR competitivo base no depende de equipos en la primera fase
- el leaderboard ranked core se puede centrar en ladders 1v1
- el matchmaking ranked no necesita lógica inicial de team assembly competitiva

### FFA público

Se definió que:

- **FFA público es totalmente aparte**

Va a tener:

- sus propias estadísticas
- su propio comportamiento
- su propia lógica de actividad

Pero OJO: eso NO significa que tenga que reinventar todo.

También tiene sentido que reutilice piezas del ecosistema Practice, por ejemplo:

- modos/kits del Practice cuando aplique
- kit layouts personalizados del jugador
- rules configurables para el mundo/arena FFA

Por lo tanto, aunque tenga identidad y stats propias, no debe confundirse con el flujo de match competitivo ni duplicar sistemas base innecesariamente.

### Party FFA

La idea planteada es:

- crear una party
- invitar amigos
- jugar en una arena en formato FFA entre los miembros de la party

Y acá la aclaración es importante:

- **Party FFA es parte del Practice**
- por lo tanto debe usar el ecosistema del Practice:
  - modos
  - kits
  - layouts
  - rules
  - y demás piezas compartidas que apliquen

### Conclusión arquitectónica

La separación correcta, por ahora, queda así:

- **Competitive Match System**
  - ranked 1v1
  - unranked con variantes configurables según modo
- **Public FFA System**
  - runtime/loop y estadísticas propias
  - reutiliza kits, layouts, modos y rules del ecosistema Practice cuando convenga
- **Party FFA / custom combat session**
  - experiencia social dentro del Practice
  - usa las piezas del Practice en vez de inventar un sistema paralelo

---

## Kit layouts / personalización del inventario

El usuario va a poder:

- acomodar su hotbar a su estilo
- agregar items
- sacar items
- editar el layout del kit

Esto implica pensar desde el negocio:

- diferencia entre kit base del servidor y layout personalizado del jugador
- validación de qué se puede mover y qué no
- persistencia de layouts por modo/kit

---

## Parties y Party Duels

Sí, se van a poder:

- crear parties
- jugar entre party
- hacer party duels

Esto sugiere más adelante:

- party state
- party invites
- party privacy/rules
- party queueing o challenges

---

## FFA

FFA existe como espacio para que los usuarios:

- entren
- maten el tiempo
- jueguen grupalmente

Además va a haber:

- varios modos de FFA
- varios maps
- selector de modos

Ejemplos dados:

- BuildUHC FFA
- CrystalPvP FFA

Esto implica que FFA no es una sola sala genérica, sino un conjunto de experiencias PvP por modo.

---

## Leaderboards y clasificaciones

Esto fue marcado como **core del Practice**.

Por lo tanto el proyecto debe contemplar desde temprano:

- leaderboards
- clasificaciones
- rank displays
- quizás top global y top por modo/kit
- actualización frecuente de estadísticas competitivas

Esto NO puede ser un agregado tardío. Tiene que influir en la arquitectura desde temprano.

---

## Perfiles públicos y progresión social

También va a haber:

- perfiles públicos
- progresión social

Esto sugiere al menos:

- perfil consultable
- visualización de stats/rank
- identidad competitiva del jugador
- capa social más allá de solo entrar a pelear

---

## Eventos hosteados por jugadores con rango

Va a existir un apartado de **eventos** creados por jugadores, específicamente jugadores con rango de paga.

### Idea base

Un jugador con rango puede:

- hostear
- crear o activar un evento

Entonces:

- se inicia el evento
- todos los jugadores pueden entrar
- los jugadores pueden unirse y jugar

### Variantes mencionadas

Los eventos pueden tener:

- diferentes mapas
- diferentes modos
- diferentes kits

Muchos kits probablemente van a ser los mismos de ranked y unranked, pero aplicados a modos distintos.

### Ejemplos de eventos mencionados

- modo torneo
  - se enfrentan 2
  - el mejor pasa
  - luego otros 2
  - luego otros 2
  - puede avanzar por eliminación
- modo por grupos
- gana el último usuario
- gana el último equipo
- parkour
- dropped

Esto implica algo MUY importante: “eventos” probablemente sea un subdominio flexible, no una sola feature pequeña.

---

## Sistema de friends

También va a existir un sistema de friends, descrito como:

- ultra intuitivo
- super bonito

### Comandos mencionados

- `/friend add (player)` → send or accept a friend request
- `/friend remove (player)` → remove a friend
- `/friend request` → view pending friends request
- `/friends` → open friends menu

Esto implica:

- solicitudes pendientes
- aceptar/rechazar
- lista de amigos
- integración con menú
- posiblemente online status y acciones rápidas

### Decisión arquitectónica recomendada para Friends

Primero lo verifiqué contra la arquitectura actual del repo.

El `AGENTS.md` define que este repositorio está centrado en **Practice** y que `practice-proxy` posee:

- transfers between servers
- routing / fallback
- proxy-side bootstrap

Y explícitamente **no** debe poseer:

- persistence

#### Conclusión correcta

Sí, **tener Friends a nivel de red/proxy es conceptualmente mejor** que tenerlo encerrado solo dentro del Hub o de un runtime Paper, porque:

- los amigos existen aunque el jugador cambie de servidor
- la presencia online/offline y ubicación en la network vive naturalmente cerca del proxy
- el mismo sistema puede servir para todas las modalidades

PERO hay un matiz crítico:

- **no** conviene que el sistema de Friends “viva” como lógica de negocio metida únicamente en `practice-proxy`
- **sí** conviene que Friends sea un **servicio/capacidad de nivel red**, con contratos compartidos y persistencia fuera del ownership del proxy

La forma sana de pensarlo es:

- `practice-api` / `practice-core` → contratos y reglas del dominio social
- `practice-data` → persistencia de friends, requests, relaciones y settings
- `practice-proxy` → integración con presencia y delivery cross-server
- `practice-hub` y otros runtimes → UX, menús, comandos y acciones del jugador

#### Traducción simple

- **Sí a Friends de nivel red**
- **No a meter toda la lógica social dentro del plugin Velocity como dueño absoluto**

Así se logra reutilización para toda la network sin romper la arquitectura.

### Recomendación de comportamiento inicial para requests sociales

#### Friend requests

- expiran luego de un tiempo razonable
- si ambos jugadores se envían request mutuamente, se puede autoaceptar
- no deberían crearse duplicados absurdos
- deben funcionar cross-server

#### Duel requests

- deben respetar settings del receptor
- si el jugador está en match, cola incompatible o estado no interactuable, deben bloquearse o rechazarse claramente
- conviene expiración corta

#### Party invites

- deben respetar settings del receptor
- conviene expiración razonable
- deben poder funcionar cross-server si la UX final lo requiere

### Principio general de retención

Toda interacción social debe ser:

- rápida
- visible
- clara
- sin spam
- respetando settings del usuario

Porque un sistema social bueno aumenta retención; uno ruidoso o confuso la destruye.

### Modelo recomendado de requests sociales

La recomendación inicial para Friends, Duels y Party Invites es diseñarlos con la misma filosofía:

- UX rápida
- comportamiento predecible
- respeto total a settings
- protección anti-spam
- funcionamiento cross-server cuando aplique

---

## Friend Requests — comportamiento recomendado

### Comando base ya definido

- `/friend add (player)` → send or accept a friend request
- `/friend remove (player)` → remove a friend
- `/friend request` → view pending friends request
- `/friends` → open friends menu

### Reglas recomendadas

#### 1. Autoaccept por solicitud recíproca

Si A envía request a B, y B luego usa `/friend add A`, la solicitud debe:

- **autoaceptarse**
- crear la relación de amistad directamente
- limpiar requests pendientes relacionadas

Esto reduce fricción y hace que el sistema se sienta inteligente.

#### 2. Expiración

La friend request debe expirar automáticamente luego de un tiempo razonable.

Recomendación inicial:

- **5 minutos**

Por qué:

- suficiente para responder sin apuro
- no deja requests zombies eternas
- evita ruido en menús y estado social

#### 3. No duplicados

No debe existir spam de múltiples solicitudes iguales entre los mismos dos jugadores.

Si ya hay una pendiente:

- no se crea otra
- se informa que ya existe una request activa

#### 4. Restricciones lógicas

No se debe permitir:

- enviarse request a uno mismo
- enviar request a alguien que ya es amigo
- enviar request a quien te tiene bloqueado por settings

#### 5. Cross-server

Las friend requests deben funcionar aunque ambos jugadores estén en distintos servidores de la network.

#### 6. Anti-spam

Recomendación inicial:

- **cooldown de 3 segundos** por target para reenviar acción social del mismo tipo

Esto no debe sentirse pesado, solo evitar abuso y flood.

---

## Duel Requests — comportamiento recomendado

### Filosofía

Las duel requests son interacciones rápidas de gameplay. Deben ser más ágiles que Friends, pero también más estrictas en estados válidos.

### Reglas recomendadas

#### 1. Expiración corta

Recomendación inicial:

- **30 segundos**

Por qué:

- si alguien quiere duelar, la intención es inmediata
- una request vieja pierde sentido muy rápido

#### 2. Respeto total a settings

La request debe bloquearse si el receptor tiene:

- duel requests desactivadas
- only friends duels activado y el emisor no es amigo

#### 3. Estados no interactuables

No debe poder enviarse o aceptarse duel si el emisor o receptor está en estado incompatible, por ejemplo:

- dentro de match
- en countdown/pre-fight irreversible
- en cola incompatible o bloqueada
- en evento que no permita interacción
- en transición entre servidores/estados

#### 4. No duplicados

Si ya existe una duel request activa entre los mismos jugadores para el mismo contexto:

- no crear otra
- informar claramente que ya existe

#### 5. Cooldown anti-spam

Recomendación inicial:

- **3 segundos** por target

#### 6. Contexto claro de la invitación

La duel request debe incluir claramente:

- modo/kit
- tipo de duelo si aplica
- formato relevante si aplica

Así la invitación no es ambigua.

---

## Party Invites — comportamiento recomendado

### Filosofía

Party Invites deben favorecer juego social y retención, así que conviene que sean cómodas, pero sin spam.

### Reglas recomendadas

#### 1. Expiración

Recomendación inicial:

- **60 segundos**

Por qué:

- más generosa que duel request
- suficiente para coordinarse socialmente

#### 2. Respeto total a settings

La invite debe bloquearse si el receptor tiene party requests desactivadas.

#### 3. Restricciones lógicas

No debe poder invitarse si:

- el target ya está en una party incompatible
- el emisor no tiene permisos/estado para invitar
- el jugador está en un estado no interactuable severo

#### 4. No duplicados

Si ya existe una invite activa de la misma party al mismo jugador:

- no duplicarla

#### 5. Cooldown anti-spam

Recomendación inicial:

- **3 segundos** por target

#### 6. Cross-server

La invite debería poder funcionar cross-server siempre que la network pueda resolver correctamente la aceptación y posterior reunión del grupo.

---

## Prioridad y limpieza de requests

### Recomendación general

- una request aceptada limpia su pendiente
- una request expirada desaparece sola
- una request invalidada por cambio de estado debe cancelarse limpiamente

Ejemplos:

- si aceptás friend request, ya no queda pendiente
- si entrás a match, una duel request vieja incompatible debe invalidarse
- si te unís a otra party, invites viejas incompatibles deben cancelarse

---

## Estados y restricción social recomendada

### Estados sociales/interactuables

Conviene pensar al jugador con una capacidad de interacción social según su estado global.

Ejemplo conceptual:

- **Hub / Lobby** → interacción total
- **FFA público** → interacción parcial
- **En cola** → interacción parcial según acción
- **En match** → interacción muy restringida
- **En evento** → depende del tipo de evento
- **Transfiriéndose** → interacción bloqueada

Esto evita lógica caótica repartida por todos lados.

---

## Decisión fuerte de UX

La mejor UX para retención es esta:

- comandos rápidos
- menú bonito
- requests visibles
- expiraciones cortas y coherentes
- autoaccept cuando tiene sentido
- cero spam innecesario
- feedback claro sobre por qué algo fue rechazado

Así Friends, Duels y Parties se sienten premium en vez de molestos.

---

## Sistema de Party — modelo recomendado

### Filosofía

La Party debe ser una herramienta **social-operativa rápida** para jugar juntos, no una mini-guild persistente.

### Estructura

Se definió:

- **un solo líder**
- el liderazgo debe poder **transferirse fácilmente**
- no hace falta sistema de roles adicional en esta primera gran fase

### Tamaño máximo

El tamaño máximo debe ser:

- **configurable**
- y además ampliable por permisos/rangos de donación

Esto permite monetización sin romper la arquitectura base.

### Acciones que la Party debe soportar

La recomendación inicial es que sí o sí pueda:

- invitar jugadores
- aceptar/rechazar invites
- expulsar miembros
- abandonar party
- transferir liderazgo
- abrir menú de party
- chat de party
- ver miembros y su estado/servidor actual
- iniciar party duels
- iniciar party FFA
- entrar juntos a experiencias grupales compatibles

### Qué pasa si el líder se desconecta

La mejor decisión NO es disolver siempre la party ni pasarla aleatoriamente.

La decisión correcta es:

- transferir liderazgo automáticamente al **miembro elegible más antiguo de la party que siga online**
- si no queda nadie online, la party se disuelve

#### Por qué

- disolver siempre genera fricción innecesaria
- asignar aleatoriamente es mala UX y puede sentirse arbitrario
- usar antigüedad online dentro de la party es predecible, simple y justa

### Restricciones por estar en Party

Sí: estar en party debe bloquear o modificar ciertas acciones individuales.

Pero OJO: esto debe ser **configurable por feature** y no una regla rígida hardcodeada para todo.

Ejemplos de restricciones configurables:

- entrar solo a ranked
- entrar solo a ciertas colas
- ir a ciertos modos FFA
- aceptar ciertas invitaciones incompatibles
- iniciar ciertas acciones individuales mientras la party exista

Esto permite adaptar la UX según el tipo de experiencia.

### Principio general

Si una acción rompe la coherencia del grupo, debe bloquearse o pedir salir de la party primero.

### Conclusión arquitectónica

La Party debe ser:

- simple en roles
- flexible en capacidad
- fuerte en UX grupal
- configurable en restricciones
- preparada para coordinar experiencias sociales sin meter complejidad innecesaria

---

## Eventos hosteados por jugadores — modelo recomendado

### Filosofía general

La decisión correcta es tratarlos como un **framework base de eventos** con:

- plantillas predefinidas
- configuración esencial controlada
- posibilidad real de escalar nuevos tipos de eventos sin dolor

No conviene construir un sistema aislado y rígido para cada evento. Conviene una base común y luego casos especiales solo cuando rompan ese modelo.

### Tipos iniciales de eventos

Se quieren contemplar inicialmente, como mínimo:

- torneo bracket
- FFA hosteado
- parkour
- dropped

Y el sistema debe quedar preparado para sumar nuevos tipos después con el menor dolor posible.

### Nivel de libertad del host

El host debe elegir sobre **plantillas predefinidas**.

Eso es lo correcto por producto y por arquitectura, porque:

- evita configuraciones absurdas o rotas
- simplifica UX
- mantiene control de calidad
- reduce bugs y edge cases

### Qué puede configurar el host

El host debe poder tocar lo esencial, siempre que ese tipo de evento lo soporte, por ejemplo:

- iniciar evento
- cancelar evento
- elegir mapa
- elegir modo
- elegir kit
- definir opciones básicas relevantes del evento

La regla correcta es:

- **configurable en lo esencial**
- **cerrado en lo peligroso o innecesario**

### Recomendación estratégica para retención

La mejor decisión es que los eventos sean **mitad competitivos y mitad sociales**, pero con un enfoque operacional claro:

- **el sistema base de eventos debe servir a la retención social**
- **algunos templates deben reforzar el prestigio competitivo**

#### Traducción práctica

- torneos/brackets → refuerzan prestigio, competición y status
- FFA hosteado / dropped / parkour → refuerzan actividad, variedad y tiempo dentro de la network

### Por qué esta mezcla es la correcta

Porque si hacés eventos solo competitivos:

- reducís participación casual
- dependés demasiado de skill gap y presión competitiva

Y si hacés eventos solo sociales:

- perdés prestigio
- bajás el valor aspiracional del ecosistema Practice

La mezcla correcta mantiene:

- actividad
- variedad
- prestigio
- retención

### Conclusión arquitectónica

La base correcta para eventos es:

- **framework de eventos**
- **templates predefinidos**
- **configuración esencial por tipo**
- **crecimiento fácil a nuevos eventos**
- mezcla de valor **competitivo + social**

---

## Definición central de “Modo” en Practice

### Decisión conceptual

Se definió que un **Modo** NO debe modelarse como:

- una cola
- un evento
- un servidor
- una experiencia runtime aislada

Se definió que un **Modo** debe ser una:

- **definición reusable de gameplay**

Eso significa que el modo representa la base jugable que luego puede reutilizarse en distintos contextos, por ejemplo:

- ranked
- unranked
- FFA público
- party FFA
- party duel
- eventos hosteados

### Por qué esta decisión es correcta

Porque permite:

- escalar nuevos modos sin dolor
- evitar ladders hardcodeadas
- reutilizar kits, rules y stats
- separar correctamente gameplay de runtime/cola/evento

### Flags de uso por modo

Sí, cada modo debe tener flags/capacidades explícitas que indiquen dónde puede utilizarse.

Ejemplos:

- usable en ranked
- usable en unranked
- usable en FFA público
- usable en party FFA
- usable en party duel
- usable en eventos

Esto evita supuestos implícitos y vuelve el sistema mucho más mantenible.

### Stats relevantes por modo

Sí, las estadísticas relevantes deben depender del modo.

No todos los modos deben medir exactamente lo mismo.

Ejemplos conceptuales:

- Sword → hits, crits, damage, combo
- Pot → pot accuracy, heals used
- Boxing → combo e intercambios relevantes
- Sumo → ringout / win condition específica
- Parkour → tiempo, checkpoints, fallos
- Dropped → supervivencia / eliminación

Esto es importante para:

- match history
- perfiles
- leaderboards
- analítica de combate

### Estructura lógica recomendada de un modo

Un modo debería contemplar al menos estos bloques conceptuales:

1. identidad
2. capacidades/flags de uso
3. player types compatibles
4. kit base / política de layout
5. match defaults
6. rule set default
7. flags competitivas
8. stats relevantes
9. arena requirements
10. compatibilidad contextual

### Versión refinada recomendada de `Mode Definition`

La versión refinada recomendada, a nivel conceptual, es esta:

#### 1. Identidad

- `identifier`
- `displayName`
- `description`
- `icon/menuItem`

#### 2. Capacidades / flags de uso

- `rankedEnabled`
- `unrankedEnabled`
- `publicFfaEnabled`
- `partyFfaEnabled`
- `partyDuelEnabled`
- `hostedEventEnabled`

#### 3. Player types compatibles

- `supportedPlayerTypes`
  - 1v1
  - 2v2
  - 3v3
  - 4v4
  - public FFA
  - party FFA

#### 4. Kit / Layout policy

- `premadeKitId`
- `layoutEditable`
- `layoutRestrictions`

#### 5. Match defaults

- `defaultRoundsToWin`
- `preFightDelay`
- `maxMatchDuration`
- `spectatorPolicy`

#### 6. Rule set default

- `defaultRules`
- `ruleParameters`

#### 7. Flags competitivas

- `rated`
- `visibleRankEnabled`
- `contributesToGlobalRating`
- `leaderboardEnabled`
- `placementsEnabled`

#### 8. Stats relevantes

- `relevantStats`

Esto permite que cada modo declare explícitamente qué stats tienen sentido para:

- historial
- perfil
- leaderboard
- resumen web/in-game

#### 9. Arena requirements

- `requiredArenaType`
- `arenaConstraints`

#### 10. Compatibilidad contextual

- `allowedQueueContexts`
- `allowedEventTemplates`
- `allowedRuntimeContexts`

### Por qué esta versión refinada es la correcta

Porque separa claramente:

- la identidad del modo
- dónde puede usarse
- cómo se juega
- qué reglas lo modifican
- cómo compite
- qué estadísticas importan

Y además deja margen real para:

- agregar campos
- quitar campos
- extender comportamiento

sin romper la idea central del dominio.

### Conclusión

La entidad **Modo** pasa a ser una de las piezas centrales del dominio de Practice.

No representa una cola ni un evento concreto, sino una base jugable reusable sobre la que viven ranked, unranked, FFA, party systems y eventos.

---

## Definición central de “Rule” en Practice

### Decisión conceptual

Se define que una **Rule** NO debe ser:

- un if suelto perdido en listeners
- una excepción hardcodeada dentro de un modo
- una condición enterrada en un runtime específico

Se define que una **Rule** debe ser una:

- **unidad declarativa y reusable de comportamiento de gameplay**

En otras palabras:

- el `Mode Definition` declara qué rules tiene activas
- la `Rule` define qué comportamiento altera
- el runtime aplica esas reglas según el contexto de ejecución

### Por qué esta decisión es correcta

Porque permite:

- agregar variaciones de gameplay sin crear modos nuevos al pedo
- reutilizar comportamiento entre ranked, unranked, FFA, party FFA y eventos
- evitar lógica duplicada y condiciones caóticas por todos lados
- mantener el dominio auditable y extensible

---

## Modelo recomendado de `Rule Definition`

La recomendación final es modelar cada Rule con estos bloques conceptuales.

### 1. Identidad

- `identifier`
- `displayName`
- `description`

Esto permite referenciarla con claridad en configs, menús internos, auditoría y tooling futuro.

### 2. Tipo de regla

Cada rule debe pertenecer a una categoría funcional clara.

Categorías recomendadas:

- `COMBAT`
- `MOVEMENT`
- `WORLD`
- `ITEM`
- `HEALTH`
- `REGEN`
- `PROJECTILE`
- `WIN_CONDITION`
- `INVENTORY`
- `POTION`
- `SPECIAL`

Esto no es solo prolijidad: ayuda a validación, compatibilidad y debugging.

### 3. Scope de aplicación

La rule debe declarar en qué scope impacta.

Ejemplos:

- `PLAYER`
- `TEAM`
- `MATCH`
- `WORLD`

Ejemplo práctico:

- `Golden Apple cooldown` impacta jugador
- `Disable break/place blocks` impacta mundo/match
- `Pressure plate instant win` impacta match/win condition

### 4. Activación

Una rule debe poder existir en tres estados conceptuales:

- activada
- desactivada
- activada con parámetros

Porque muchas rules no son solo booleanas.

Ejemplos:

- `Ender pearl cooldown = 16s`
- `Golden Apple cooldown = 20s`
- `Extra hearts = 4`
- `Timed block = 10s`

### 5. Parámetros

Las rules deben aceptar parámetros tipados cuando haga falta.

Tipos recomendados:

- boolean
- int
- double
- duration
- enum/lista cerrada
- potion effect set

Esto evita reglas hardcodeadas por variante y hace que el sistema sea realmente poderoso.

### 6. Contextos compatibles

Cada rule debe declarar dónde puede usarse.

Ejemplos:

- compatible con ranked
- compatible con unranked
- compatible con public FFA
- compatible con party FFA
- compatible con hosted events

Y también, cuando haga falta:

- compatible con ciertos tipos de modo
- incompatible con ciertos event templates

Esto es importante porque no toda rule tiene sentido en todo contexto.

### 7. Fase de ejecución

Cada rule debe declarar cuándo entra en juego.

Fases recomendadas:

- `PRE_MATCH`
- `MATCH_START`
- `IN_MATCH`
- `ON_DAMAGE`
- `ON_MOVE`
- `ON_ITEM_USE`
- `ON_BLOCK_PLACE`
- `ON_BLOCK_BREAK`
- `ON_DEATH`
- `ON_WIN_CHECK`
- `POST_MATCH`

Esto baja muchísimo el caos al aplicar reglas.

### 8. Conflictos / incompatibilidades

Algunas rules pueden ser incompatibles entre sí.

Ejemplos conceptuales:

- `Health does not regenerate` vs una rule que fuerce regeneración especial
- `Disable ender pearl` vs `Ender pearl cooldown`
- `Disable item drop` vs mecánicas que dependan de dropeo

Por lo tanto, una rule debe poder declarar:

- `conflictsWith`
- o una política de precedencia

### 9. Stats/telemetría relacionadas

Algunas rules impactan qué stats tiene sentido capturar o mostrar.

Ejemplos:

- `Potion effects` puede habilitar telemetría asociada
- `Only arrow damage` hace más importantes stats de projectile
- `Timed block` puede volver relevante una stat de block lifecycle si alguna vez se desea

No hace falta sobrecomplicarlo ahora, pero el modelo debe admitirlo.

### 10. Mensajería / visibilidad

Una rule debería poder indicar si merece feedback visible para jugador/admin.

Ejemplos:

- mostrar cooldown activo
- mostrar mensaje cuando una acción está bloqueada por rule
- mostrar condición especial de victoria

Esto no significa acoplarla a UI, solo permitir que la UX la represente bien.

---

## Recomendación estructural fuerte

La mejor forma de pensarlo es esta:

- **`Rule Definition`** = contrato declarativo
- **`Rule Set`** = colección de rules activas + parámetros
- **`Rule Engine / Rule Handlers`** = aplicación runtime de esas rules

Y NO esto:

- modo gigante con 200 ifs
- listeners llenos de flags sueltas
- lógica repetida por cada ladder

### Traducción simple

- el modo dice **qué reglas usa**
- el rule set dice **con qué configuración exacta**
- el runtime dice **cómo se aplican en ejecución**

---

## Ejemplos de cómo encaja esto

### Ejemplo 1 — Sword base

- no hunger loss
- no fall damage
- disable crafting slots

### Ejemplo 2 — BuildUHC-like

- block place/break permitido
- golden head insta consumable
- water/lava behavior especial

### Ejemplo 3 — Event variant

- base de Sword
- extra hearts
- pressure plate instant win
- max duration ajustada

O sea: no creás un modo totalmente nuevo si solo cambian algunas rules.

---

## Decisiones concretas que tomo

### 1. Las rules deben ser reutilizables entre contextos

Sí.

Una buena rule no debería pertenecer solo a ranked o solo a eventos si conceptualmente puede aplicarse en más lugares.

### 2. Las rules deben poder tener parámetros

Sí.

Sin parámetros, el sistema se queda chico demasiado rápido.

### 3. Debe existir validación de compatibilidades

Sí.

No podemos permitir combinaciones absurdas o conflictivas sin validación.

### 4. Las rules deben ser declarativas antes que hardcodeadas

Sí.

La implementación runtime existirá igual, pero el dominio debe modelarlas declarativamente.

### 5. Los modos especiales seguirán existiendo

Sí.

Este sistema de rules NO elimina la necesidad de modos especiales como Sumo, Boxing, Bridge o Dropped.
Lo que hace es evitar convertir cualquier pequeña variación en un modo especial innecesario.

---

## Conclusión

La entidad **Rule** pasa a ser la segunda pieza más importante del dominio, junto con `Mode Definition`.

`Mode Definition` define la experiencia base.
`Rule Definition` define cómo esa experiencia puede alterarse, especializarse y escalar sin dolor.

---

## Definición central de “Queue” en Practice

### Decisión conceptual

Se define que una **Queue** NO debe modelarse como:

- un modo
- un match
- una party
- un botón del menú

Se define que una **Queue** debe ser un:

- **contexto de búsqueda y emparejamiento**

En otras palabras:

- el `Mode Definition` dice **qué gameplay se juega**
- la `Queue` dice **cómo se busca rival para jugarlo**

### Por qué esta decisión es correcta

Porque permite separar correctamente:

- identidad del gameplay
- política competitiva
- player type
- restricciones de matchmaking
- tipo de acceso del jugador

Y evita errores clásicos como acoplar Sword directamente a una única cola rígida.

---

## Modelo recomendado de `Queue Definition`

La recomendación final es que una cola tenga estos bloques conceptuales.

### 1. Identidad

- `identifier`
- `displayName`
- `description`
- `menuItem`

Esto permite representar la cola en hub, menús y logs de forma limpia.

### 2. Clasificación de la cola

La cola debe declarar qué tipo de experiencia representa.

Campos recomendados:

- `queueType`
  - `RANKED`
  - `UNRANKED`
  - más adelante podrían existir otros tipos si realmente hacen falta

- `competitive`
- `rated`

#### Decisión fuerte

- **Ranked y Unranked deben ser colas distintas**
- no deben ser un simple flag suelto pegado al match

### 3. Relación con el modo

La cola debe referenciar explícitamente:

- `modeId`

Y opcionalmente, cuando haga falta en el futuro:

- `modeVariant` o contexto especializado

Ejemplo conceptual:

- `ranked-sword-1v1`
- `unranked-sword-1v1`

Ambas usan el mismo `Mode Definition` base, pero no son la misma cola.

### 4. Player type / team format

La cola debe fijar con claridad el formato de enfrentamiento.

Campos recomendados:

- `playerType`
  - 1v1
  - 2v2
  - 3v3
  - 4v4

#### Decisión actual

- Ranked inicial será **1v1 solamente**
- Unranked podrá crecer luego con otros formatos

### 5. Política de matchmaking

La cola debe declarar qué política usa el sistema de matchmaking.

Campos recomendados:

- `matchmakingProfile`
  - `QUALITY_FIRST`
  - `SPEED_FIRST`

- `usesSr`
- `usesPingRange`
- `usesRegionSelection`
- `searchExpansionProfile`

#### Decisión fuerte

- Ranked usa perfil **quality-first**
- Unranked usa perfil **speed-first**

### 6. Restricciones de acceso

La cola debe poder declarar quién puede entrar y bajo qué condiciones.

Campos recomendados:

- `requiresSoloState`
- `requiresPartyState`
- `allowedPlayerStates`
- `blockedPlayerStates`
- `permissionRequirements`

Esto es importante porque ya decidimos que estar en party puede bloquear ciertas acciones, y eso debe poder modelarse por cola.

### 7. Restricciones sociales / de grupo

La cola debe declarar cómo interactúa con el sistema social.

Campos recomendados:

- `blockedIfInParty`
- `leavePartyRequired`
- `partyJoinAllowed`
- `spectatorAllowed`

#### Decisión actual

- Ranked 1v1 debe bloquear entrada mientras el jugador mantenga estados grupales incompatibles

### 8. Política de arena / region / runtime

La cola debe poder expresar lo necesario para materializar el match.

Campos recomendados:

- `arenaSelectionPolicy`
- `regionPolicy`
- `targetRuntime`
  - por ejemplo Match runtime

Esto no significa que la cola asigne ella misma la arena, sino que declara qué necesita el flujo para resolverla.

### 9. Política competitiva visible

La cola debe decir qué impacto tiene sobre el perfil competitivo del jugador.

Campos recomendados:

- `affectsSr`
- `affectsVisibleRank`
- `affectsGlobalRating`
- `affectsSeasonStats`
- `affectsLeaderboards`

Esto mantiene claro por qué Ranked y Unranked no pueden confundirse.

### 10. Visibilidad y UX

La cola debe declarar cómo se presenta al usuario.

Campos recomendados:

- `visibleInMenu`
- `menuCategory`
- `sortOrder`
- `statusMessagingProfile`

Porque una cola también es una pieza de UX, no solo backend.

---

## Recomendación estructural fuerte

La mejor forma de pensarlo es así:

- **`Mode Definition`** = experiencia jugable reusable
- **`Queue Definition`** = contexto de acceso y matchmaking para esa experiencia
- **`Queue Entry`** = jugador o grupo actualmente buscando partida en esa cola
- **`Matchmaking Policy`** = lógica que evalúa candidatos dentro de la cola

Y NO así:

- el modo hace de cola
- la cola hace de match
- el menú define la lógica competitiva

---

## Ejemplos conceptuales

### Ejemplo 1 — Ranked Sword 1v1

- usa `modeId = sword`
- `queueType = RANKED`
- `playerType = 1v1`
- `matchmakingProfile = QUALITY_FIRST`
- afecta SR, rank, global rating, season y leaderboard
- bloquea estados incompatibles como party activa

### Ejemplo 2 — Unranked Sword 1v1

- usa `modeId = sword`
- `queueType = UNRANKED`
- `playerType = 1v1`
- `matchmakingProfile = SPEED_FIRST`
- no afecta SR/rank principal
- sigue usando región y ping range, pero con tolerancia más laxa

---

## Decisiones concretas que tomo

### 1. Queue y Mode deben ser entidades separadas

Sí.

Esto es obligatorio si querés escalar bien ranked, unranked y futuras variantes.

### 2. Ranked y Unranked deben ser colas distintas

Sí.

Comparten modo, pero no comparten identidad competitiva.

### 3. Queue debe poder bloquear por estado social

Sí.

Ya definimos parties, requests y estados incompatibles; la cola debe integrarse con eso declarativamente.

### 4. Queue debe declarar su política de matchmaking

Sí.

No quiero esa lógica escondida en condicionales externos. Tiene que estar modelada.

### 5. Queue debe influir explícitamente en perfil competitivo

Sí.

No podemos dejar implícito qué colas afectan SR, ranks, season o leaderboard.

---

## Conclusión

La entidad **Queue** pasa a ser la pieza que conecta:

- el `Mode Definition`
- la política de matchmaking
- las restricciones del jugador
- la materialización del match

`Mode` define qué se juega.
`Queue` define cómo se entra a buscarlo.

---

## Definición central de “Match” en Practice

### Decisión conceptual

Se define que un **Match** NO debe modelarse como:

- solo una teletransportación a una arena
- solo una sesión Paper runtime sin identidad de dominio
- solo un resultado final persistido

Se define que un **Match** debe ser una:

- **sesión competitiva/jugable materializada a partir de una Queue y un Mode**

En otras palabras:

- `Mode` define qué gameplay base se juega
- `Queue` define cómo se encontró ese enfrentamiento
- `Match` representa la ejecución real de esa experiencia

### Por qué esta decisión es correcta

Porque el Match es el punto donde confluyen:

- matchmaking
- arena
- región
- runtime target
- jugadores/equipos
- rules activas
- rounds
- resultado
- historial y telemetría

Y si no se modela como entidad real, todo termina desparramado entre plugins, caches y callbacks.

---

## Modelo recomendado de `Match Session`

La recomendación final es que un Match tenga estos bloques conceptuales.

### 1. Identidad

- `matchId`
- `createdAt`
- `startedAt`
- `endedAt`
- `status`

El Match debe tener identidad propia desde antes de iniciar realmente, no recién al persistir resultado.

### 2. Origen del match

- `queueId`
- `modeId`
- `playerType`
- `queueType`
- `matchmakingProfileUsed`

Esto deja trazabilidad clara de por qué ese match existe.

### 3. Participantes

- `participants`
- `teamsOrSides`
- `partyReferences` si aplica en contextos grupales futuros
- `playerStateSnapshotAtCreation` mínimo si hace falta validar integridad

#### Decisión fuerte

Aunque Ranked inicial sea 1v1, el modelo de Match debe nacer preparado para lados/equipos, porque Unranked y otros contextos van a crecer.

### 4. Ubicación operativa

- `region`
- `arenaId`
- `arenaType`
- `runtimeServerId`
- `runtimeType`

Esto es obligatorio para debug, recovery y auditoría.

### 5. Configuración efectiva del match

El Match NO debe depender solo del `Mode Definition` en vivo, sino de una configuración efectiva resuelta al momento de creación.

Campos recomendados:

- `effectiveRules`
- `effectiveMatchSettings`
- `effectiveKitReference`
- `effectiveRoundsToWin`
- `effectivePreFightDelay`
- `effectiveMaxDuration`

#### Por qué

Porque si mañana cambia un modo o una rule, el Match histórico no puede reinterpretarse con datos distintos a los que realmente usó.

### 6. Ciclo de vida / estados

El Match debe tener estados explícitos.

Estados recomendados:

- `CREATED`
- `ALLOCATING`
- `TRANSFERRING`
- `WAITING_PLAYERS`
- `PRE_FIGHT`
- `IN_PROGRESS`
- `ROUND_ENDING`
- `COMPLETED`
- `CANCELLED`
- `FAILED`

#### Por qué

Sin estados claros, recovery, debugging y UX se vuelven caóticos.

### 7. Modelo de rounds/series

Como ya definimos lógica best-of-X, el Match debe contemplar explícitamente:

- `seriesFormat`
- `roundsToWin`
- `currentRound`
- `roundResults`
- `scoreboardBySide`

#### Decisión fuerte

El modelo de Match debe soportar series desde el principio. No hay que meter bo3 como parche encima de bo1.

### 8. Política de spectators

El Match debe saber:

- si permite spectators
- bajo qué condiciones
- si fue restringido por settings de los jugadores

Esto no tiene que quedar perdido en listeners del runtime.

### 9. Resultado competitivo

El Match debe declarar explícitamente:

- `winner`
- `loser` o `winningSide`
- `resultType`
  - normal win
  - disconnect
  - timeout
  - special win condition
- `srChanges`
- `rankImpact`
- `seasonImpact`

Esto es crítico para trazabilidad competitiva.

### 10. Historial y telemetría

El Match debe ser el dueño lógico de:

- metadata del match
- snapshot final por jugador
- stats agregadas
- eventos mínimos importantes
- snapshot final de inventario por slots

O sea: el historial no es un agregado externo raro; nace de la sesión Match.

### 11. Cancelación / falla / recovery

El Match debe contemplar caminos no felices.

Campos recomendados:

- `cancelReason`
- `failureReason`
- `recoverable`
- `cleanupStatus`

#### Por qué

Porque en una network real va a haber:

- disconnects
- transfer failures
- arena issues
- timeouts
- players que no cargan

Si no modelás eso desde el dominio, terminás parchando errores por todos lados.

---

## Recomendación estructural fuerte

La mejor forma de pensarlo es así:

- **`Mode Definition`** = experiencia base
- **`Queue Definition`** = contexto de acceso y matchmaking
- **`Match Session`** = ejecución real y auditable de esa experiencia
- **`Match History`** = proyección/persistencia de salida derivada del Match

Y NO así:

- el servidor Paper "es" el match
- la arena "es" el match
- el resultado persistido "es" el match

---

## Ejemplos conceptuales

### Ejemplo 1 — Ranked Sword 1v1 bo3

- nace desde `ranked-sword-1v1`
- usa `modeId = sword`
- región elegida por mejor calidad común
- arena asignada
- effective rules + settings congelados
- score por rounds
- resultado final con impacto de SR

### Ejemplo 2 — Unranked Sword 1v1

- misma base jugable
- distinta cola
- distinta política competitiva
- historial igual de consistente
- sin impacto en SR principal

---

## Decisiones concretas que tomo

### 1. Match debe tener configuración efectiva congelada

Sí.

Esto es obligatorio para histórico correcto y trazabilidad.

### 2. Match debe modelar estados explícitos

Sí.

Sin eso, el runtime se vuelve opaco y difícil de recuperar.

### 3. Match debe soportar series/rounds nativamente

Sí.

Ya definimos bo3 y variantes por modo; no se parchea después.

### 4. Match debe ser dueño lógico del historial

Sí.

El historial sale del Match, no de listeners desordenados sueltos.

### 5. Match debe modelar failure/cancelation paths

Sí.

Esto es arquitectura seria de network, no plugin local improvisado.

---

## Conclusión

La entidad **Match Session** pasa a ser la ejecución real del corazón competitivo de Practice.

`Mode` define la experiencia.
`Queue` define cómo se accede.
`Match` define cómo esa experiencia ocurrió realmente.

---

## Definición central de “Arena” en Practice

### Decisión conceptual

Se define que un **Arena** NO debe modelarse como:

- solo un nombre bonito en config
- solo una world location suelta
- solo un mapa visual

Se define que un **Arena** debe ser una:

- **unidad reusable, compatible y reservable de ejecución de match o actividad**

En otras palabras:

- `Mode` define qué se juega
- `Queue` define cómo se busca
- `Match` define la sesión real
- `Arena` define **dónde puede ejecutarse correctamente esa sesión**

### Por qué esta decisión es correcta

Porque el arena debe resolver cosas reales de dominio y operación:

- compatibilidad con modos
- compatibilidad con player types
- región
- lifecycle de reserva/uso/liberación
- reutilización segura
- observabilidad/debug

Si el arena no se modela bien, después tenés arenas “ocupadas” fantasma, incompatibilidades raras y lógica hardcodeada por plugin.

---

## Modelo recomendado de `Arena Definition`

La recomendación final es que un Arena tenga estos bloques conceptuales.

### 1. Identidad

- `arenaId`
- `displayName`
- `description`

Debe poder identificarse con claridad para logs, administración y selección.

### 2. Clasificación

El arena debe declarar qué tipo de experiencia soporta.

Campos recomendados:

- `arenaType`
  - `DUEL`
  - `TEAM`
  - `PUBLIC_FFA`
  - `PARTY_FFA`
  - `EVENT`

#### Decisión fuerte

No conviene usar una sola noción genérica de arena para todo sin clasificación. FFA público, duel y evento no tienen exactamente las mismas necesidades operativas.

### 3. Compatibilidad con modos

El arena debe declarar explícitamente qué puede soportar.

Campos recomendados:

- `allowedModes`
- `blockedModes`
- `allowedPlayerTypes`
- `supportedEventTemplates`

#### Por qué

Porque no todas las arenas sirven para todos los modos aunque técnicamente “entren” jugadores adentro.

### 4. Región y runtime

El arena debe vivir asociado a una región y a un contexto operativo.

Campos recomendados:

- `region`
- `runtimeType`
- `serverPool` o referencia equivalente

Esto es importante para matchmaking, asignación y debugging.

### 5. Layout espacial / puntos de uso

El arena debe declarar los puntos necesarios según el tipo.

Ejemplos:

- `spawnA`
- `spawnB`
- `teamSpawns`
- `spectatorSpawn`
- `lobbySpawn` interno si aplica
- `bounds`
- `specialZones`

#### Importante

No hace falta meter lógica visual rara acá; hace falta modelar los puntos funcionales que el runtime necesita.

### Definición operativa al crear arenas

Al momento de crear/configurar una arena, debe poder definirse explícitamente:

- `identifier`
- `displayName`
- `icon`
- posiciones/spawns relevantes según el tipo de arena

Y además dos regiones funcionales muy importantes:

#### 1. Universal region

La **universal region** define el área general del mapa que se usa para:

- protección global
- clonación
- manejo general del espacio de la arena

#### 2. Battle region

La **battle region** define el área real de combate, usada para:

- proteger correctamente el mapa durante la partida
- asegurar que los jugadores no salgan del área válida
- validar límites de combate/movimiento

### Posiciones configurables por arena

Según el tipo de arena, debe poder marcarse por GUI/herramienta de setup al menos:

- `position1`
- `position2`
- `spectatorPosition`
- spawns de duelo (A/B)
- spawns de team si aplica
- posiciones FFA / Party FFA si aplica

#### Decisión fuerte

Estas posiciones y regiones no deben quedar como datos secundarios improvisados. Deben formar parte explícita del contrato operativo de la arena.

### 6. Requerimientos ambientales

El arena debe declarar restricciones o capacidades del mundo.

Ejemplos:

- soporta block place/break
- soporta liquid interactions
- soporta void/lava/water kill conditions
- soporta pressure-plate win condition
- soporta timed blocks

### Decisión fuerte

No toda compatibilidad debe venir solo del `Mode`. Hay arenas que también imponen o limitan comportamiento por su propia naturaleza.

### 7. Política de reserva

Esto es CRÍTICO.

El arena debe poder pasar por estados operativos claros.

Estados recomendados:

- `AVAILABLE`
- `RESERVED`
- `IN_USE`
- `RESETTING`
- `DISABLED`
- `BROKEN`

#### Por qué

Porque una arena en una network seria no puede ser “true/false ocupada”. Necesitás trazabilidad real.

### 8. Política de reset / cleanup

El arena debe declarar cómo vuelve a estado limpio.

Campos recomendados:

- `resetStrategy`
- `requiresWorldRollback`
- `requiresBlockCleanup`
- `requiresEntityCleanup`
- `cleanupTimeout`

Esto importa muchísimo en modos con bloques, líquidos o efectos temporales.

### 9. Visibilidad / rotación / peso

El arena debe poder participar de selección inteligente.

Campos recomendados:

- `enabled`
- `selectable`
- `selectionWeight`
- `featured`

Esto permite:

- sacar arenas sin borrarlas
- controlar rotación
- priorizar algunas en cierto contexto

### 10. Telemetría y auditoría

El arena debe ser auditable.

Campos recomendados:

- `lastUsedAt`
- `timesUsed`
- `lastFailureReason`
- `healthStatus`

#### Por qué

Porque si una arena empieza a fallar o a dar problemas, tenés que poder detectarlo sin adivinar.

---

## Recomendación estructural fuerte

La mejor forma de pensarlo es así:

- **`Arena Definition`** = contrato estático/casi estático del espacio jugable
- **`Arena Reservation`** = estado operativo temporal de asignación
- **`Arena Allocation Policy`** = lógica que decide cuál arena compatible usar

Y NO así:

- un yaml gigante sin modelo
- una arena “ocupada o no” sin contexto
- el match decidiendo todo ad hoc

---

## Ejemplos conceptuales

### Ejemplo 1 — Arena de duel Sword

- `arenaType = DUEL`
- región `NA`
- soporta `1v1`
- spawns A/B
- spectator spawn
- weight normal
- reset simple

### Ejemplo 2 — Arena BuildUHC-like

- `arenaType = DUEL`
- soporta block placement/break
- requiere cleanup de bloques
- puede necesitar rollback o reset más fuerte

### Ejemplo 3 — Public FFA map

- `arenaType = PUBLIC_FFA`
- múltiples puntos de spawn
- runtime distinto
- stats y lifecycle propios
- no debe confundirse con una arena de duelo

---

## Decisiones concretas que tomo

### 1. Arena debe ser entidad separada de Match

Sí.

El Match la usa; no la define.

### 2. Arena debe tener compatibilidad declarativa

Sí.

No quiero inferencias mágicas ni hardcodeo escondido.

### 3. Arena debe tener estados operativos explícitos

Sí.

Necesitamos reservar, usar, resetear y deshabilitar con trazabilidad.

### 4. Arena debe contemplar cleanup/reset como parte del diseño

Sí.

Especialmente porque ya sabemos que habrá modos con reglas de bloques y comportamiento ambiental.

### 5. FFA público y eventos pueden reutilizar concepto de arena, pero no deben forzarse al mismo flujo operativo que un duel simple

Sí.

Comparten concepto base, pero no tienen exactamente el mismo lifecycle.

---

## Conclusión

La entidad **Arena** pasa a ser el contrato de compatibilidad y ejecución espacial del sistema.

`Mode` dice qué se juega.
`Queue` dice cómo se busca.
`Match` dice qué pasó.
`Arena` dice dónde puede ocurrir correctamente.

---

## Definición central de “Player State” en Practice

### Decisión conceptual

Se define que el **estado del jugador** NO debe quedar implícito en:

- el servidor en el que está
- flags sueltas desperdigadas
- checks repetidos en menús, listeners y comandos

Se define que debe existir un **Player State System** explícito que modele en qué situación global está el jugador dentro de Practice.

### Por qué esta decisión es correcta

Porque el estado del jugador afecta directamente:

- si puede entrar a cola
- si puede recibir duel requests
- si puede usar party actions
- si puede spectear
- si puede entrar a FFA
- si puede participar en eventos
- si puede transferirse
- si puede ser matcheado

Sin este sistema, todo termina en ifs repetidos y contradicciones entre runtimes.

---

## Modelo recomendado de `Player State`

La recomendación final es separar:

- **estado global principal**
- **subestado contextual**
- **restricciones derivadas**

### 1. Estado global principal

Estados recomendados:

- `OFFLINE`
- `HUB`
- `IN_QUEUE`
- `TRANSFERRING`
- `IN_MATCH`
- `SPECTATING`
- `IN_PUBLIC_FFA`
- `IN_PARTY_FFA`
- `IN_EVENT`
- `EDITING_LAYOUT`

#### Decisión fuerte

Estos estados deben ser mutuamente excluyentes a nivel principal.

No quiero un jugador “medio en cola, medio en FFA, medio transfiriéndose”.

### 2. Subestado contextual

Además del estado principal, el jugador puede tener un subestado descriptivo.

Ejemplos:

- en `IN_QUEUE`
  - `WAITING_MATCH`

- en `IN_MATCH`
  - `WAITING_PLAYERS`
  - `PRE_FIGHT`
  - `IN_ROUND`
  - `ROUND_ENDING`

- en `IN_EVENT`
  - `REGISTERED`
  - `ACTIVE`
  - `ELIMINATED`
  - `SPECTATING_EVENT`

Esto mejora muchísimo la coherencia sin inflar el estado principal.

### 3. Restricciones derivadas

El Player State System debe permitir derivar si una acción está permitida o no.

Ejemplos:

- `canReceiveDuels`
- `canSendDuels`
- `canJoinQueue`
- `canJoinFfa`
- `canJoinEvent`
- `canEditLayout`
- `canReceivePartyInvite`
- `canSpectate`
- `canBeTransferred`

#### Decisión fuerte

Estas restricciones no deben vivir hardcodeadas por cada menú. Deben resolverse desde una política central basada en estado + settings + contexto.

---

## Reglas operativas recomendadas por estado

### `HUB`

- interacción total
- puede recibir requests sociales
- puede entrar a cola
- puede abrir menús
- puede editar layouts

### `IN_QUEUE`

- interacción parcial
- puede recibir social actions según configuración
- no debe poder entrar a otra cola incompatible
- no debe poder iniciar acciones que rompan la coherencia del matchmaking

### `TRANSFERRING`

- interacción bloqueada casi por completo
- no recibe acciones nuevas importantes
- no debe aceptar cambios de estado paralelos

### `IN_MATCH`

- interacción social fuertemente restringida
- no recibe duel requests nuevas
- no entra a colas
- no modifica layout
- spectate depende del contexto y settings del match

### `IN_PUBLIC_FFA`

- interacción parcial
- puede mantener algunas acciones sociales
- no debe mezclarse con cola o match competitivo al mismo tiempo

### `IN_PARTY_FFA`

- similar a experiencia grupal activa
- restricciones más parecidas a sesión grupal que a hub libre

### `IN_EVENT`

- depende del template del evento
- pero en general no debe superponerse con cola o match competitivo paralelo

### `EDITING_LAYOUT`

- estado de interacción enfocada
- no debe poder ser arrastrado silenciosamente a otras acciones destructivas sin validación clara

---

## Recomendación estructural fuerte

La mejor forma de pensarlo es así:

- **`Player State`** = fotografía global actual del jugador en Practice
- **`State Policy`** = reglas que dicen qué acciones están permitidas por estado
- **`Transition Rules`** = reglas válidas para pasar de un estado a otro

Y NO así:

- cada runtime inventa sus propios flags
- cada menú decide por su cuenta si algo se puede hacer
- cada comando chequea estados distintos de forma inconsistente

---

## Transiciones válidas recomendadas

Ejemplos de transiciones sanas:

- `HUB -> IN_QUEUE`
- `IN_QUEUE -> TRANSFERRING`
- `TRANSFERRING -> IN_MATCH`
- `IN_MATCH -> HUB`
- `HUB -> IN_PUBLIC_FFA`
- `IN_PUBLIC_FFA -> HUB`
- `HUB -> EDITING_LAYOUT`
- `EDITING_LAYOUT -> HUB`
- `HUB -> IN_EVENT`
- `IN_EVENT -> HUB`

### Decisión fuerte

Las transiciones inválidas deben rechazarse explícitamente.

Ejemplo:

- `IN_MATCH -> IN_QUEUE` directamente = no
- `TRANSFERRING -> EDITING_LAYOUT` = no
- `IN_PUBLIC_FFA -> IN_MATCH` sin flujo de salida/entrada válido = no

---

## Integración con settings y social

El estado del jugador NO reemplaza settings, los complementa.

Ejemplo:

- si el estado permite recibir duels, todavía hay que chequear si el setting del usuario también lo permite
- si el estado permite spectate, todavía hay que chequear si el jugador objetivo lo tiene habilitado

### Regla simple

- **state dice si es posible estructuralmente**
- **settings dicen si el usuario lo permite**

---

## Decisiones concretas que tomo

### 1. Debe existir un estado global principal único

Sí.

Es la forma más limpia de evitar contradicciones entre sistemas.

### 2. Deben existir subestados contextuales

Sí.

Dan precisión sin romper la claridad del estado principal.

### 3. Las acciones permitidas deben derivarse centralmente desde estado + settings + contexto

Sí.

Eso evita lógica duplicada y errores de UX.

### 4. Las transiciones deben ser explícitas

Sí.

No quiero cambios implícitos mágicos entre runtimes.

### 5. `TRANSFERRING` debe ser estado real

Sí.

En una network, transferencia no es un detalle: es una etapa crítica donde pasan muchos edge cases.

---

## Conclusión

El **Player State System** pasa a ser la columna vertebral de coherencia operativa del jugador dentro de Practice.

Sin él, social, colas, matches, FFA y eventos se pisan.
Con él, el sistema se vuelve predecible, seguro y mantenible.

---

## Definición central de “Profile / Stats System” en Practice

### Decisión conceptual

Se define que el **perfil del jugador** NO debe ser:

- solo un contenedor de stats sueltas
- solo una pantalla linda del menú
- solo una fila grande en base de datos sin límites claros

Se define que el perfil debe ser una:

- **identidad consultable del jugador dentro del ecosistema Practice**

Y el sistema de stats debe ser una:

- **proyección estructurada del rendimiento, actividad e identidad competitiva/social del jugador**

### Por qué esta decisión es correcta

Porque el perfil va a ser usado por:

- menú de estadísticas
- perfiles públicos
- leaderboards
- seasons
- historial
- social/friends
- futura capa web

Si no se separa bien qué pertenece al perfil y qué pertenece a stats/proyecciones, el modelo termina siendo un monstruo difícil de escalar.

---

## Modelo recomendado del `Practice Profile`

La recomendación final es separar el sistema en 5 bloques grandes.

### 1. Identidad base del perfil

Esto representa quién es el jugador dentro de Practice.

Campos recomendados:

- `playerId / uuid`
- `currentName`
- `normalizedName`
- `firstSeenAt`
- `lastSeenAt`
- `profileVisibility` si más adelante hace falta
- `currentGlobalRating`
- `currentGlobalRank`

#### Decisión fuerte

El perfil debe tener identidad pública clara aunque parte de sus stats especializadas nazcan lazy.

### 2. Datos competitivos actuales

Esto representa el estado competitivo vigente del jugador.

Debe contemplar:

- SR por modo
- rango por modo
- placements state por modo si aplica
- Global Rating actual
- rango global actual
- resumen competitivo actual de la season vigente

#### Importante

Esto es “estado actual”, no histórico completo.

### 3. Estadísticas agregadas por dimensión

Acá está una decisión MUY importante.

No conviene meter todas las stats en un solo bloque.

La separación correcta es:

#### a. All-time stats

Ejemplos:

- wins/losses totales
- matches played totales
- kills/deaths globales si aplica
- activity totals
- eventos ganados totales

#### b. Season stats

Ejemplos:

- ranked wins de la season
- ranked losses de la season
- top placement de la season
- global rating peak de la season
- stats FFA/evento de la season si se deciden mostrar

#### c. Mode stats

Ejemplos:

- Sword ranked wins/losses
- Sword current SR
- Sword peak SR
- Pot-specific performance stats
- stats relevantes según el modo

#### d. Social/activity stats

Ejemplos:

- friends count
- parties joined
- events hosted
- events joined
- social participation signals

#### Decisión fuerte

Las stats deben dividirse por dimensión, no guardarse como una bolsa gigante indiferenciada.

### 4. Proyecciones de leaderboard

El perfil no debe ser el leaderboard mismo, pero sí debe exponer la información necesaria para alimentar leaderboards.

Ejemplos:

- current leaderboard-eligible values
- seasonal leaderboard values
- per-mode leaderboard values

#### Decisión fuerte

Los leaderboards deben leerse desde proyecciones optimizadas, no calcularse ad hoc leyendo perfiles gigantes cada vez.

### 5. Perfil público presentable

El sistema debe poder proyectar un perfil público bonito y útil, con:

- identidad del jugador
- rango global
- global rating
- rangos/SR por modo
- season highlights
- historial reciente
- stats importantes
- señales sociales relevantes

#### Decisión fuerte

El perfil público no debe exponer todo. Debe exponer lo valioso para prestigio, comparación y retención.

---

## Qué stats recomiendo considerar base desde ahora

### Competitivas base

- ranked matches played
- ranked wins
- ranked losses
- win rate
- current SR per mode
- peak SR per mode
- current global rating
- peak global rating

### Historial / performance

- recent matches count
- recent win/loss trend
- average match duration si resulta útil

### FFA base

- FFA kills
- FFA deaths
- streak peak
- time played

### Eventos base

- events hosted
- events joined
- events won

### Sociales base

- friends count
- party sessions joined

### Decisión fuerte

No recomiendo inflar el perfil inicial con 200 métricas exóticas. Mejor empezar con stats que:

- den valor al jugador
- alimenten leaderboards
- sirvan para comparación real
- tengan buena relación señal/ruido

---

## Relación entre Match History y Profile Stats

Esto es MUY importante.

La recomendación correcta es:

- `Match History` guarda el detalle de cada sesión
- `Profile Stats` guardan agregados/proyecciones derivadas

#### Traducción simple

- el historial responde: “qué pasó en este match”
- el perfil responde: “qué representa ese jugador a lo largo del tiempo”

No conviene mezclar esas dos responsabilidades.

---

## Relación entre Season y All-Time

La separación correcta es:

- **current state**
- **current season projections**
- **all-time projections**

#### Decisión fuerte

No quiero que una season nueva borre la identidad histórica del jugador. Quiero que resetee la capa competitiva vigente, pero conservando histórico y prestigio acumulado.

---

## Qué recomiendo mostrar en el perfil público principal

La mejor primera versión del perfil público debería priorizar:

- nombre
- rango global actual
- Global Rating actual
- top 3 o top N modos más fuertes
- season actual resumida
- historial reciente
- algunas stats clave
- badges/reconocimientos futuros si se agregan

### Por qué

Porque el perfil público debe ser:

- aspiracional
- legible
- comparable
- útil para retención

No un dashboard técnico lleno de ruido.

---

## Decisiones concretas que tomo

### 1. Perfil y stats deben separarse conceptualmente

Sí.

Perfil = identidad pública y estado actual.
Stats = proyecciones agregadas por dimensión.

### 2. Debe haber separación explícita entre all-time, season y per-mode

Sí.

Eso es obligatorio si querés seasons sanas y perfiles útiles.

### 3. El perfil público debe priorizar prestigio y comparación

Sí.

No hace falta mostrar absolutamente todo para que sea valioso.

### 4. Los leaderboards deben vivir sobre proyecciones, no sobre consultas improvisadas a perfiles completos

Sí.

Esto es una decisión de performance y diseño desde ahora.

### 5. FFA, eventos y social deben tener stats propias, pero sin contaminar la identidad competitiva core

Sí.

Eso mantiene limpio el corazón del Practice competitivo sin perder riqueza social.

---

## Conclusión

El **Profile / Stats System** pasa a ser la capa de identidad, prestigio y proyección del jugador dentro de Practice.

`Match History` cuenta lo que pasó.
`Profile` muestra quién sos.
`Stats` resumen lo que lograste.
`Leaderboards` comparan ese valor dentro del ecosistema.

---

## Data Ownership — qué vive en MySQL y qué vive en Redis

### Decisión conceptual

Se define que:

- **MySQL es la fuente de verdad**
- **Redis es el hot-state y la capa de coordinación rápida**

Y esto NO puede quedar ambiguo.

Porque si mezclamos ownership, después pasa lo peor:

- datos duplicados con versiones distintas
- estados imposibles de reconciliar
- bugs de desincronización
- lógica inventada por cada runtime

### Regla madre

#### MySQL debe guardar

- datos que deben sobrevivir reinicios
- datos históricos
- datos de identidad
- datos competitivos persistentes
- datos auditables

#### Redis debe guardar

- presencia actual
- estado actual del jugador
- colas activas
- matches activos
- locks/cooldowns
- proyecciones rápidas
- coordinación entre runtimes

---

## Qué debe vivir en MySQL

### 1. Player profile persistente

- identidad base del jugador
- first seen / last seen
- settings persistentes
- visibilidad/perfil público si aplica

### 2. Datos competitivos persistentes

- SR por modo
- rango por modo
- Global Rating
- rango global
- peaks importantes
- estado de placements cuando aplique

### 3. Seasons e histórico competitivo

- snapshot de season
- stats por season
- cortes históricos
- datos all-time
- rewards manuales entregados o registrables si luego hace falta

### 4. Match history persistente

- metadata del match
- datos por jugador
- stats agregadas
- eventos mínimos importantes
- snapshot final del inventario

### 5. Relaciones sociales persistentes

- friendships
- social preferences persistentes
- historial social básico si luego hace falta

### 6. Layouts persistentes

- layout por kit/modo del jugador

### 7. Arenas / definiciones configurables persistentes

- arena definitions
- regiones/spawns/config operativa

### 8. Catálogos/config persistentes del sistema

- modes
- rules
- queues
- event templates
- configuraciones administrativas persistentes

---

## Qué debe vivir en Redis

### 1. Presencia actual del jugador

- online/offline práctico
- runtime actual
- server actual
- player state actual
- subestado contextual si hace falta

### 2. Queue state

- entradas activas de cola
- timestamps de entrada
- snapshots rápidos para matchmaking
- ventanas de expansión por tiempo

### 3. Match state activo

- matches en curso
- estado operativo del match
- participantes activos
- arena reservada
- runtime asociado
- score/round state activo si hace falta coordinación rápida

### 4. Arena reservation / operational state

- arena reservada
- arena en uso
- arena reseteando
- locks temporales

### 5. Requests sociales efímeras

- friend requests pendientes
- duel requests pendientes
- party invites pendientes

#### Decisión fuerte

Las requests pendientes son efímeras y temporales. No tiene sentido tratarlas como core persistence pesada en MySQL desde el inicio.

### 6. Cooldowns, locks y anti-spam

- cooldowns sociales
- locks de transición
- locks de matchmaking
- protections de duplicidad temporal

### 7. Proyecciones rápidas / counters vivos

- jugadores en hub
- jugadores en cola
- jugadores en match
- jugadores en FFA
- contadores globales visibles

### 8. Delivery / coordinación cross-runtime

- eventos de transición
- señales de invalidación
- sincronización operativa rápida

---

## Qué NO debe pasar

### Error 1 — Persistir en Redis algo que es fuente de verdad

Ejemplo malo:

- SR oficial solo en Redis
- historial oficial solo en Redis

No.

Si importa a largo plazo o a nivel competitivo, va a MySQL.

### Error 2 — Usar MySQL para hot-paths de runtime

Ejemplo malo:

- consultar MySQL cada vez que cambia estado de cola
- consultar MySQL en pleno combate para decisiones rápidas

No.

Eso rompe performance y escala mal.

### Error 3 — Dual ownership ambiguo

Ejemplo malo:

- Redis y MySQL ambos creyendo tener “el estado real” de una cola o de un match activo

No.

Hay que definir claramente qué es persistente y qué es operativo.

---

## Recomendación estructural fuerte

La forma correcta de pensarlo es:

- **MySQL** = verdad persistente
- **Redis** = verdad operativa actual
- **proyecciones** = derivaciones optimizadas según necesidad

### Traducción simple

- si querés saber qué pasó históricamente → MySQL
- si querés saber qué está pasando AHORA → Redis

---

## Decisiones concretas que tomo

### 1. Player state actual vive en Redis

Sí.

Porque cambia rápido, coordina runtimes y no debe depender de lecturas persistentes pesadas.

### 2. SR/ranks/history viven en MySQL

Sí.

Porque son identidad competitiva persistente.

### 3. Queue active state vive en Redis

Sí.

Porque es hot-state puro.

### 4. Match activo vive operativamente en Redis, pero su salida/historial vive en MySQL

Sí.

Ese corte es exactamente el correcto.

### 5. Friendships persistentes viven en MySQL, requests pendientes en Redis

Sí.

Persistencia durable para relaciones, efímero para requests temporales.

### 6. Counters globales y visibilidad en tiempo real deben salir de Redis/proyecciones rápidas

Sí.

No de consultas pesadas cada vez.

---

## Conclusión

La arquitectura correcta de datos para Practice es:

- **MySQL para identidad, competitivo, histórico y configuración persistente**
- **Redis para coordinación, presencia, colas, matches activos, requests efímeras y contadores vivos**

Ese corte mantiene:

- coherencia
- rendimiento
- auditabilidad
- escalabilidad

---

## Matriz operativa de ownership por entidad

Para que el diseño no quede abstracto, esta es la tabla recomendada de ownership real por entidad.

| Entidad | Source of Truth | Redis / Hot State | Notas |
|---|---|---|---|
| Practice Profile | MySQL | Cache opcional si hace falta | Identidad persistente del jugador |
| User Settings | MySQL | Cache opcional | Configuración persistente por usuario |
| Current Player State | Redis | Redis | Estado operativo actual del jugador |
| Player Presence | Redis | Redis | Online/offline, runtime y server actual |
| SR por modo | MySQL | Cache/proyección opcional | Identidad competitiva persistente |
| Rango por modo | MySQL | Cache/proyección opcional | Derivado o persistido según implementación |
| Global Rating | MySQL | Cache/proyección opcional | Valor competitivo persistente |
| Global Rank | MySQL / proyección persistente | Cache opcional | Mejor como proyección optimizada |
| Season snapshots | MySQL | No | Histórico y corte de season |
| All-time stats | MySQL | Cache opcional | Agregados persistentes |
| Season stats | MySQL | Cache opcional | Agregados por season |
| Mode stats | MySQL | Cache opcional | Agregados por modo |
| Social/activity stats | MySQL | Cache opcional | Friends count, events joined, etc. |
| Friendship | MySQL | Cache opcional | Relación social persistente |
| Friend Request pendiente | Redis | Redis | Efímera, expirable |
| Duel Request pendiente | Redis | Redis | Efímera, expirable |
| Party Invite pendiente | Redis | Redis | Efímera, expirable |
| Party actual | Redis | Redis | Estado grupal operativo actual |
| Queue Definition | MySQL | Cache opcional | Catálogo/config persistente |
| Queue Entry activa | Redis | Redis | Hot-state puro |
| Matchmaking search window | Redis | Redis | Expansión por tiempo y coordinación |
| Match Session activa | Redis | Redis | Lifecycle operativo actual |
| Match Result / Match History | MySQL | No | Histórico y auditoría |
| Match stats detalladas | MySQL | No | Persistencia del resumen/historial |
| Inventory final snapshot | MySQL | No | Parte del match history |
| Arena Definition | MySQL | Cache opcional | Configuración persistente |
| Arena Reservation / Arena State | Redis | Redis | Reserva, uso, resetting, locks |
| Mode Definition | MySQL | Cache opcional | Catálogo/config persistente |
| Rule Definition | MySQL | Cache opcional | Catálogo/config persistente |
| Rule Set efectivo en match | Redis durante ejecución / MySQL al persistir resultado | Redis | En vivo durante match; congelado en histórico al finalizar |
| Event Template | MySQL | Cache opcional | Configuración persistente |
| Hosted Event activo | Redis | Redis | Lifecycle operativo del evento |
| Hosted Event history | MySQL | No | Si se decide persistir histórico del evento |
| Leaderboard projection | Redis + persistencia/proyección en MySQL si conviene | Redis | Debe ser lectura optimizada, no cálculo ad hoc |
| Global counters (hub, queue, ffa, match) | Redis | Redis | Tiempo real |
| Cooldowns / anti-spam | Redis | Redis | Temporales por naturaleza |
| Transition locks | Redis | Redis | Protegen race conditions y duplicidad |

### Reglas prácticas de lectura

#### Leer de MySQL cuando

- importa el histórico
- importa la persistencia real
- importa auditoría
- importa identidad duradera

#### Leer de Redis cuando

- importa el ahora
- importa coordinación entre runtimes
- importa performance de hot path
- importa evitar carreras y duplicados temporales

### Decisión fuerte

Si una entidad tiene versión en MySQL y Redis, NO significa doble ownership.

Significa:

- MySQL conserva la verdad persistente
- Redis mantiene una proyección o estado operativo temporal

Ese matiz es CLAVE para no destruir la arquitectura.

---

## Application Services — capa de orquestación del sistema

### Decisión conceptual

Se define que los **Application Services** NO deben convertirse en:

- managers gigantes
- contenedores caóticos de lógica mezclada
- wrappers vacíos sin criterio

Se define que deben ser:

- **servicios pequeños, explícitos y orientados a casos de uso**

### Por qué esta decisión es correcta

Porque ya definimos bien el dominio. Ahora necesitamos la capa que conecte:

- entidades del dominio
- persistencia
- hot-state
- runtimes
- flujos reales del jugador

Sin convertir todo en plugins obesos ni en clases “God Object”.

---

## Regla madre de Application Services

### El dominio decide

- reglas
- compatibilidades
- estados válidos
- identidad de las entidades

### Los Application Services orquestan

- lecturas/escrituras
- transiciones
- validaciones de flujo
- coordinación entre módulos
- side effects controlados

### Los runtimes adaptan

- eventos de plataforma
- comandos
- menús
- feedback visual

#### Traducción simple

- `practice-core` piensa
- `practice-data` persiste
- plugin/runtime conecta con Paper/Velocity

---

## Lista recomendada de Application Services

La recomendación final es arrancar con estos servicios y NO inventar más hasta necesitarlos.

### 1. `ProfileService`

#### Responsabilidad

- bootstrap del jugador al entrar por primera vez
- carga del perfil actual
- acceso al perfil público
- actualización de metadata básica

#### Debe orquestar

- profile persistente
- settings persistentes
- season context actual

#### No debe hacer

- matchmaking
- lógica de match
- social completa

---

### 2. `PlayerStateService`

#### Responsabilidad

- leer y actualizar el estado global actual del jugador
- validar transiciones de estado
- resolver acciones permitidas según estado + settings + contexto

#### Debe orquestar

- Redis player state
- policy de transición
- locks si hacen falta

#### Es crítico porque

sin este servicio cada runtime empezaría a inventar su propia lógica de estado.

---

### 3. `QueueService`

#### Responsabilidad

- entrar a cola
- salir de cola
- validar elegibilidad para una cola
- materializar `QueueEntry`

#### Debe orquestar

- `Queue Definition`
- player state
- restricciones sociales/party
- Redis queue state

#### No debe hacer

- elegir rival final por sí solo
- crear el match completo por sí solo

Eso pertenece al matchmaking + match service.

---

### 4. `MatchmakingService`

#### Responsabilidad

- evaluar candidatos dentro de una cola
- aplicar política quality-first / speed-first
- respetar ping range, región y expansión temporal
- decidir pairing válido

#### Debe orquestar

- queue state activo
- reglas de matching
- región óptima
- score de calidad del pairing

#### No debe hacer

- teletransportar jugadores
- administrar runtime Paper directamente

Su trabajo es decidir el emparejamiento correcto.

---

### 5. `ArenaAllocationService`

#### Responsabilidad

- encontrar arena compatible
- reservarla
- marcar estados operativos
- liberarla al terminar o fallar

#### Debe orquestar

- `Arena Definition`
- `Arena Reservation`
- compatibilidad con modo/player type/región

#### No debe hacer

- lógica de score/rank
- lógica social

---

### 6. `MatchService`

#### Responsabilidad

- crear `Match Session`
- congelar configuración efectiva
- coordinar creación, inicio, progreso y cierre del match
- persistir resultado e historial derivado

#### Debe orquestar

- `Mode Definition`
- `Queue Definition`
- `Match Session`
- arena asignada
- runtime target
- SR/result impact

#### Decisión fuerte

Este es uno de los servicios más importantes del sistema. Pero incluso así, NO debe tragarse matchmaking, social ni queueing completo.

---

### 7. `RatingService`

#### Responsabilidad

- calcular cambios de SR
- recalcular rangos por modo
- recalcular Global Rating
- aplicar impacto competitivo post-match

#### Debe orquestar

- reglas de rating
- datos competitivos persistentes
- peaks y season impact

#### No debe hacer

- decidir ganador del match
- manejar runtime

Trabaja sobre resultados ya resueltos.

---

### 8. `HistoryService`

#### Responsabilidad

- construir y persistir el resumen/historial del match
- exponer consultas del historial reciente
- preparar datos consumibles por menús y futura web

#### Debe orquestar

- metadata
- player snapshots
- stats agregadas
- eventos mínimos
- inventory final snapshot

#### Nota

Puede recibir como fuente principal un `Match Session` ya terminado.

---

### 9. `FriendsService`

#### Responsabilidad

- gestionar relaciones de amistad
- enviar/aceptar/eliminar friends
- resolver visibilidad social básica

#### Debe orquestar

- friendships persistentes
- requests pendientes
- settings sociales
- delivery cross-server cuando aplique

#### No debe hacer

- lógica de party
- lógica de duelos completa

---

### 10. `PartyService`

#### Responsabilidad

- crear/disolver party
- invitar/expulsar miembros
- transferir liderazgo
- resolver restricciones grupales

#### Debe orquestar

- party state activo
- party invites pendientes
- presencia de miembros
- restricciones por estado

---

### 11. `DuelRequestService`

#### Responsabilidad

- enviar/aceptar/cancelar duel requests
- validar settings/estado
- convertir aceptación válida en flujo hacia party duel o match challenge según contexto

#### Nota

Separarlo de `FriendsService` mantiene limpio el dominio social vs desafío de gameplay.

---

### 12. `FfaService`

#### Responsabilidad

- entrada/salida de FFA público
- lifecycle operativo del jugador en FFA
- stats activas de FFA
- integración con modos/rules/layouts reutilizados

#### Decisión fuerte

FFA público tiene loop propio. Merece servicio propio.

---

### 13. `EventService`

#### Responsabilidad

- crear evento hosteado desde template
- abrir/cerrar inscripciones
- iniciar/cancelar evento
- coordinar lifecycle del evento activo

#### Debe orquestar

- event templates
- hosted event active state
- presencia de jugadores
- restricciones del template

---

### 14. `LeaderboardProjectionService`

#### Responsabilidad

- construir/actualizar proyecciones de leaderboard
- exponer top global y top por modo/season
- mantener lecturas rápidas

#### Decisión fuerte

Los leaderboards NO deben salir de consultas improvisadas sobre perfiles completos.

---

### 15. `StatsProjectionService`

#### Responsabilidad

- actualizar stats agregadas a partir de resultados/historial
- mantener separación entre all-time, season, per-mode y social/activity

#### Nota

Esto evita mezclar cálculo de stats con el flujo del match en tiempo real.

---

## Servicios que NO recomiendo crear todavía

Para respetar el principio de evitar sobreingeniería, NO recomiendo crear desde ya:

- `CosmeticsService` complejo
- `NotificationService` genérico monstruoso
- `AdminEverythingManager`
- `NetworkService` todoterreno

Si más adelante aparecen casos reales, se modelan. No antes.

---

## Orquestación recomendada del flujo principal

### Ranked / Unranked principal

1. `ProfileService` asegura contexto del jugador
2. `PlayerStateService` valida estado actual
3. `QueueService` intenta entrada a cola
4. `MatchmakingService` encuentra pairing válido
5. `ArenaAllocationService` reserva arena compatible
6. `MatchService` crea sesión efectiva
7. runtime ejecuta la partida
8. `MatchService` cierra resultado
9. `RatingService` aplica impacto competitivo si corresponde
10. `HistoryService` persiste historial
11. `StatsProjectionService` actualiza agregados
12. `LeaderboardProjectionService` refresca proyecciones relevantes
13. `PlayerStateService` devuelve al jugador a estado consistente

### Social / Party

1. `FriendsService` y `PartyService` resuelven relaciones e invitaciones
2. `DuelRequestService` resuelve desafíos directos
3. `PlayerStateService` gobierna compatibilidad de acciones

### Eventos

1. `EventService` crea desde template
2. `PlayerStateService` valida entradas
3. `ArenaAllocationService` / runtime resuelven espacio según tipo
4. `StatsProjectionService` y `HistoryService` persisten lo que corresponda

---

## Decisiones concretas que tomo

### 1. Sí a servicios pequeños y explícitos

Sí.

Prefiero 12-15 servicios con responsabilidad clara antes que 3 managers gigantes imposibles de mantener.

### 2. `MatchService`, `QueueService`, `MatchmakingService` y `ArenaAllocationService` deben existir separados

Sí.

Separar esos cuatro es CLAVE para que el corazón competitivo no se vuelva una masa acoplada.

### 3. Social debe separarse en Friends, Party y Duel Request

Sí.

Parecen cercanos, pero no son lo mismo a nivel de flujo ni de restricciones.

### 4. Leaderboards y stats deben salir de proyecciones, no de lógica embebida en match runtime

Sí.

Eso protege rendimiento y claridad del sistema.

### 5. FFA y Events merecen servicios propios

Sí.

Porque tienen loop y lifecycle propios.

---

## Conclusión

La capa de **Application Services** es la que va a convertir todo este dominio bien definido en un sistema implementable, sin romper principios ni caer en sobreingeniería.

Dominio sólido arriba.
Persistencia/hot-state abajo.
Servicios explícitos en el medio.
Runtimes finos en la superficie.

---

## Persistencia concreta — diseño inicial MySQL + Redis

### Objetivo

Bajar el ownership ya definido a contratos concretos de persistencia para poder empezar a desarrollar sin ambigüedad.

### Principio rector

- **MySQL** guarda identidad, histórico, competitivo y configuración persistente.
- **Redis** guarda hot-state, coordinación y proyecciones rápidas.

No se busca un modelo perfecto y eterno. Se busca un modelo inicial **limpio, auditable, escalable y fácil de evolucionar**.

---

## MySQL — tablas iniciales recomendadas

### 1. `practice_players`

#### Propósito
Identidad base persistente del jugador dentro de Practice.

#### Campos base recomendados
- `player_id` (uuid, pk)
- `current_name`
- `normalized_name`
- `first_seen_at`
- `last_seen_at`
- `created_at`
- `updated_at`

---

### 2. `practice_player_settings`

#### Propósito
Settings persistentes por usuario.

#### Campos base recomendados
- `player_id` (pk/fk)
- `chat_enabled`
- `duel_requests_enabled`
- `friends_only_duels_enabled`
- `friend_requests_enabled`
- `spectate_enabled`
- `lobby_players_visible`
- `party_requests_enabled`
- `event_alerts_enabled`
- `scoreboard_enabled`
- `ping_range_setting`
- `updated_at`

---

### 3. `practice_modes`

#### Propósito
Catálogo persistente de `Mode Definition`.

#### Campos base recomendados
- `mode_id` (pk)
- `display_name`
- `description`
- `icon_material`
- `icon_data_json`
- `ranked_enabled`
- `unranked_enabled`
- `public_ffa_enabled`
- `party_ffa_enabled`
- `party_duel_enabled`
- `hosted_event_enabled`
- `layout_editable`
- `premade_kit_id`
- `default_match_settings_json`
- `competitive_flags_json`
- `relevant_stats_json`
- `arena_requirements_json`
- `context_compatibility_json`
- `enabled`
- `created_at`
- `updated_at`

---

### 4. `practice_rules`

#### Propósito
Catálogo persistente de `Rule Definition`.

#### Campos base recomendados
- `rule_id` (pk)
- `display_name`
- `description`
- `category`
- `scope`
- `parameter_schema_json`
- `compatible_contexts_json`
- `execution_phases_json`
- `conflicts_with_json`
- `telemetry_hints_json`
- `visibility_hints_json`
- `enabled`
- `created_at`
- `updated_at`

---

### 5. `practice_mode_rules`

#### Propósito
Asignación de rules por modo con parámetros efectivos por defecto.

#### Campos base recomendados
- `mode_id` (pk/fk parcial)
- `rule_id` (pk/fk parcial)
- `enabled`
- `parameters_json`
- `created_at`
- `updated_at`

---

### 6. `practice_queues`

#### Propósito
Catálogo persistente de `Queue Definition`.

#### Campos base recomendados
- `queue_id` (pk)
- `display_name`
- `description`
- `queue_type`
- `mode_id`
- `player_type`
- `matchmaking_profile`
- `uses_sr`
- `uses_ping_range`
- `uses_region_selection`
- `search_expansion_profile_json`
- `access_rules_json`
- `social_rules_json`
- `arena_policy_json`
- `competitive_impact_json`
- `visibility_json`
- `enabled`
- `created_at`
- `updated_at`

---

### 7. `practice_arenas`

#### Propósito
Catálogo persistente de `Arena Definition`.

#### Campos base recomendados
- `arena_id` (pk)
- `display_name`
- `description`
- `arena_type`
- `region`
- `runtime_type`
- `server_pool`
- `icon_material`
- `allowed_modes_json`
- `blocked_modes_json`
- `allowed_player_types_json`
- `supported_event_templates_json`
- `universal_region_json`
- `battle_region_json`
- `positions_json`
- `environment_capabilities_json`
- `reset_strategy_json`
- `selection_weight`
- `featured`
- `enabled`
- `created_at`
- `updated_at`

---

### 8. `practice_player_mode_ratings`

#### Propósito
Estado competitivo actual por modo.

#### Campos base recomendados
- `player_id` (pk/fk parcial)
- `mode_id` (pk/fk parcial)
- `current_sr`
- `current_rank_key`
- `peak_sr`
- `peak_rank_key`
- `placements_completed`
- `placements_progress`
- `season_id`
- `updated_at`

#### Nota
Si el rating vigente es por season, esta tabla representa el estado actual de la season activa.

---

### 9. `practice_player_global_rating`

#### Propósito
Estado global competitivo actual del jugador.

#### Campos base recomendados
- `player_id` (pk/fk)
- `current_global_rating`
- `current_global_rank_key`
- `peak_global_rating`
- `peak_global_rank_key`
- `season_id`
- `updated_at`

---

### 10. `practice_player_mode_stats`

#### Propósito
Stats agregadas por jugador y por modo.

#### Campos base recomendados
- `player_id` (pk/fk parcial)
- `mode_id` (pk/fk parcial)
- `scope_type` (`ALL_TIME` / `SEASON`)
- `season_id` (nullable según scope)
- `stats_json`
- `updated_at`

#### Decisión fuerte
Para stats agregadas por modo, arrancar con `stats_json` es más flexible que abrir 80 columnas demasiado pronto.

---

### 11. `practice_player_core_stats`

#### Propósito
Stats agregadas globales no atadas a un modo específico.

#### Campos base recomendados
- `player_id` (pk/fk parcial)
- `scope_type` (`ALL_TIME` / `SEASON`)
- `season_id` (nullable)
- `stats_json`
- `updated_at`

Ejemplos:
- total ranked wins/losses
- total events hosted/joined/won
- total FFA kills/deaths si decidimos consolidarlas acá o en tabla separada

---

### 12. `practice_player_kit_layouts`

#### Propósito
Layouts personalizados por jugador y modo/kit.

#### Campos base recomendados
- `player_id` (pk/fk parcial)
- `mode_id` (pk/fk parcial)
- `layout_key` (pk parcial si hace falta múltiple variante)
- `layout_json`
- `updated_at`

---

### 13. `practice_friendships`

#### Propósito
Relación social persistente.

#### Campos base recomendados
- `friendship_id` (pk)
- `player_a_id`
- `player_b_id`
- `created_at`

#### Decisión fuerte
Normalizar internamente el par para evitar duplicados invertidos.

---

### 14. `practice_seasons`

#### Propósito
Registro de seasons y cortes históricos.

#### Campos base recomendados
- `season_id` (pk)
- `display_name`
- `status` (`ACTIVE`, `CLOSED`, etc.)
- `started_at`
- `ended_at`
- `closed_manually_by`
- `notes`
- `created_at`

---

### 15. `practice_matches`

#### Propósito
Metadata principal persistente del `Match Session` terminado.

#### Campos base recomendados
- `match_id` (pk)
- `queue_id`
- `mode_id`
- `queue_type`
- `player_type`
- `region`
- `arena_id`
- `runtime_server_id`
- `status_final`
- `result_type`
- `series_format`
- `rounds_to_win`
- `started_at`
- `ended_at`
- `duration_ms`
- `effective_settings_json`
- `effective_rules_json`
- `winner_side`
- `created_at`

---

### 16. `practice_match_players`

#### Propósito
Snapshot por jugador dentro de un match persistido.

#### Campos base recomendados
- `match_id` (pk/fk parcial)
- `player_id` (pk/fk parcial)
- `player_name`
- `side_key`
- `result`
- `sr_before`
- `sr_after`
- `sr_delta`
- `health_final`
- `ping_final`
- `armor_snapshot_json`
- `inventory_snapshot_json`
- `consumables_snapshot_json`
- `effects_snapshot_json`
- `stats_json`

---

### 17. `practice_match_events`

#### Propósito
Eventos mínimos importantes del historial de match.

#### Campos base recomendados
- `match_event_id` (pk)
- `match_id` (fk)
- `event_type`
- `round_number`
- `actor_player_id` (nullable)
- `target_player_id` (nullable)
- `payload_json`
- `occurred_at`

---

### 18. `practice_event_templates`

#### Propósito
Plantillas persistentes del framework de eventos hosteados.

#### Campos base recomendados
- `event_template_id` (pk)
- `display_name`
- `event_type`
- `base_mode_id` (nullable)
- `configuration_json`
- `enabled`
- `created_at`
- `updated_at`

---

### 19. `practice_hosted_event_history`

#### Propósito
Histórico persistente de eventos hosteados si decidimos guardarlo desde primera fase.

#### Campos base recomendados
- `hosted_event_id` (pk)
- `event_template_id`
- `host_player_id`
- `status_final`
- `region`
- `arena_id`
- `started_at`
- `ended_at`
- `summary_json`

---

## Redis — claves y estructuras iniciales recomendadas

### Convención general

Usar prefijo claro:

- `practice:`

Y namespaces por agregado:

- `practice:player:*`
- `practice:queue:*`
- `practice:match:*`
- `practice:arena:*`
- `practice:party:*`
- `practice:social:*`
- `practice:event:*`
- `practice:counter:*`

---

### 1. Player presence y state

#### Claves recomendadas
- `practice:player:{playerId}:presence`
- `practice:player:{playerId}:state`

#### Estructura sugerida
Redis Hash

Campos ejemplo:
- `online`
- `runtime`
- `server`
- `state`
- `substate`
- `updatedAt`

---

### 2. Queue entries activas

#### Claves recomendadas
- `practice:queue:{queueId}:entries`
- `practice:player:{playerId}:queue`

#### Estructura sugerida
- Sorted Set para entries por timestamp
- Hash/String auxiliar por jugador para acceso directo

#### Mi recomendación
- `Sorted Set` por cola usando `joinedAt` como score
- `Hash` o `String` por jugador con snapshot breve de queue entry

---

### 3. Matchmaking windows / search expansion

#### Claves recomendadas
- `practice:queue:{queueId}:search:{playerId}`

#### Estructura sugerida
Redis Hash

Campos ejemplo:
- `joinedAt`
- `currentExpansionStage`
- `lastEvaluatedAt`
- `pingRangeSetting`
- `regionHints`

---

### 4. Match sessions activas

#### Claves recomendadas
- `practice:match:{matchId}`
- `practice:player:{playerId}:active-match`

#### Estructura sugerida
Redis Hash

Campos ejemplo:
- `status`
- `queueId`
- `modeId`
- `arenaId`
- `region`
- `runtimeServerId`
- `round`
- `score`
- `createdAt`

---

### 5. Arena operational state

#### Claves recomendadas
- `practice:arena:{arenaId}:state`
- `practice:arena:{arenaId}:lock`

#### Estructura sugerida
- Hash para estado
- Lock key con TTL para reservas/transiciones críticas

Campos ejemplo:
- `status`
- `reservedBy`
- `matchId`
- `updatedAt`

---

### 6. Party active state

#### Claves recomendadas
- `practice:party:{partyId}`
- `practice:player:{playerId}:party`

#### Estructura sugerida
- Hash para metadata de la party
- Set/List para miembros

Campos ejemplo:
- `leaderId`
- `status`
- `createdAt`
- `memberLimit`

---

### 7. Social requests pendientes

#### Claves recomendadas
- `practice:social:friend-request:{senderId}:{targetId}`
- `practice:social:duel-request:{senderId}:{targetId}`
- `practice:social:party-invite:{partyId}:{targetId}`

#### Estructura sugerida
String o Hash con TTL

#### TTL recomendados
- friend request → 5 min
- duel request → 30 s
- party invite → 60 s

---

### 8. Cooldowns / anti-spam / locks

#### Claves recomendadas
- `practice:cooldown:{type}:{actorId}:{targetId}`
- `practice:lock:transition:{playerId}`
- `practice:lock:matchmaking:{queueId}:{playerId}`

#### Estructura sugerida
String con TTL

---

### 9. Hosted events activos

#### Claves recomendadas
- `practice:event:{eventId}`
- `practice:event:{eventId}:participants`

#### Estructura sugerida
- Hash para metadata del evento activo
- Set/Sorted Set para participantes

---

### 10. Counters globales

#### Claves recomendadas
- `practice:counter:hub`
- `practice:counter:queue`
- `practice:counter:match`
- `practice:counter:ffa`
- `practice:counter:event`

#### Estructura sugerida
String/Counter atómico simple

---

### 11. Leaderboard projections rápidas

#### Claves recomendadas
- `practice:leaderboard:global`
- `practice:leaderboard:season:{seasonId}:global`
- `practice:leaderboard:mode:{modeId}`
- `practice:leaderboard:season:{seasonId}:mode:{modeId}`

#### Estructura sugerida
Sorted Set

#### Score recomendado
- SR o Global Rating según leaderboard

---

## Decisiones fuertes de modelado

### 1. Configuración compleja inicial en JSON donde conviene

Sí.

Para `Mode`, `Rule`, `Queue`, `Arena` y `Event Template`, conviene arrancar con varios campos `*_json` en lugar de hiper-normalizar demasiado pronto.

#### Por qué
- reduce fricción inicial
- mantiene flexibilidad
- evita 40 tablas de config prematuras

### 2. Datos core competitivos deben estar más estructurados

Sí.

Profile, ratings, seasons, match metadata y friendships deben tener estructura clara, no todo en blobs.

### 3. Redis debe modelar agregados operativos, no espejos completos de MySQL

Sí.

Solo lo necesario para hot path y coordinación.

### 4. Leaderboards deben usar Sorted Sets en Redis

Sí.

Es la opción más natural para lecturas rápidas y top-N.

### 5. Queue entries deben usar Sorted Set por tiempo

Sí.

Eso simplifica expansión progresiva y matching por antigüedad.

---

## Conclusión

Con este diseño inicial ya tenemos una base concreta para pasar a:

- contratos de repositorio/gateway
- implementación de `practice-data`
- claves Redis reales
- primera capa de servicios

Sin improvisar storage en mitad del desarrollo.

---

## Settings por usuario

Va a haber una sección de settings por usuario.

Ejemplos mencionados:

- activar o desactivar el chat
- activar o desactivar que te puedan enviar duels
- activar o desactivar recibir solo duel requests de amigos
- activar o desactivar el envío de solicitudes de friends
- activar o desactivar si los jugadores pueden spectear tus partidas
- activar o desactivar ver jugadores en el lobby
- activar o desactivar que te puedan enviar solicitud de party
- activar o desactivar alertas de torneos o “hosteo de eventos”
- activar o desactivar el scoreboard

### Ping Range para matchmaking

También se quiere un setting de **Ping Range** para limitar el matchmaking a oponentes con ping dentro del rango seleccionado.

Opciones mencionadas:

- Within 25ms of you
- Within 50ms of you
- Within 75ms of you
- Within 100ms of you
- Within 125ms of you
- Within 150ms of you
- Within 200ms of you
- Within 250ms of you
- No Limit

Esto es relevante porque afecta directamente al diseño del matchmaking.

---

## Matchmaking

Se dejó explícitamente como requisito crítico:

> Debemos tener el mejor, moderno, optimizado, impecable, eficiente sistema de matchmaking.

Esto significa que el matchmaking no puede verse solo como “sacar dos jugadores de una cola”.

Va a tener que considerar, probablemente:

- SR/rating
- kit o modo
- región
- ping range
- tiempos de cola
- calidad de match
- fairness vs rapidez

Este punto es de arquitectura core.

### Decisión inicial de diseño

La recomendación base para Practice competitivo es esta:

- **Ranked = quality first, speed second**
- **Unranked = speed first, quality second**
- el sistema debe usar **matching por score de calidad**, no un simple “primer rival disponible”
- las restricciones deben **relajarse progresivamente por tiempo en cola**, pero sin romper reglas duras importantes

### Reglas duras iniciales

Para considerar una pareja válida, ambos jugadores deben cumplir al menos:

- misma cola / mismo modo
- mismo tipo de enfrentamiento compatible
- no estar bloqueados por otro estado del sistema
- existir al menos una **región común jugable** para ambos
- respetar el **Ping Range** configurado por ambos jugadores

### Ping Range como preferencia real del usuario

El setting de Ping Range debe tratarse como una preferencia fuerte del usuario.

Eso significa que:

- si un jugador elige un rango de ping estricto, el sistema no debería ignorarlo silenciosamente
- si la cola no encuentra rival por esa razón, es mejor informar que sugeriría ampliar el rango antes que hacer un match injusto sin avisar

### Selección de región

La región del match no debería ser simplemente fija por defecto si el sistema puede elegir mejor.

La lógica recomendada es:

- evaluar las regiones posibles para ambos jugadores
- elegir la **mejor región común**
- priorizar la menor combinación de:
  - ping máximo entre ambos
  - diferencia de ping entre ambos
  - estabilidad/calidad esperada del match

### Ranked matchmaking — política recomendada

En Ranked 1v1, la prioridad debe ser:

1. calidad competitiva del rival
2. calidad de conexión
3. tiempo de espera razonable

#### Expansión progresiva recomendada para Ranked

Los valores exactos se pueden ajustar luego, pero la lógica inicial recomendada es:

- **0-15s**
  - rival muy cercano en SR
  - mejor región común disponible
  - match de máxima calidad posible

- **15-30s**
  - ampliar un poco el rango de SR
  - permitir más regiones comunes viables

- **30-45s**
  - ampliar más el rango de SR
  - seguir priorizando fairness por ping

- **45-60s**
  - permitir una búsqueda claramente más amplia
  - mantener todavía límites sanos de calidad

- **60s+**
  - búsqueda amplia, pero sin generar matches absurdos
  - no romper preferencias fuertes ni crear partidas evidentemente malas

### Unranked matchmaking — política recomendada

En Unranked, la prioridad debe ser:

1. rapidez saludable
2. match suficientemente justo
3. conexión aceptable

La recomendación es que Unranked use el SR del modo como referencia de habilidad cuando exista, pero con tolerancia más amplia que Ranked.

Eso permite:

- evitar emparejamientos totalmente rotos
- no convertir Unranked en una cola lenta e hiperestricta

### Por qué esta decisión es la mejor base

Porque un Practice competitivo se arruina por dos extremos:

- **si priorizás solo velocidad**, el ranked se siente injusto y amateur
- **si priorizás solo perfección**, las colas se vuelven lentas y frustrantes

La solución correcta es:

- empezar estricto
- relajar inteligentemente
- no traicionar settings importantes del jugador
- separar claramente el comportamiento de Ranked y Unranked

---

## Estadísticas globales en tiempo real

También se quieren estadísticas operativas y visibles que se actualicen constantemente.

Ejemplos mencionados:

- cuántas personas están en el hub de practice
- cuántas están en partida
- cuántas están en FFA
- cuántas están en cola
- y muchas estadísticas más que se van actualizando a cada momento

Esto implica desde temprano:

- presencia global
- proyecciones o contadores hot-state
- actualización en tiempo real o casi real

---

## Conclusión actual de producto

La visión inicial combina tres capas:

1. **Competitive Practice core**
   - ranked
   - unranked
   - rounds / series
   - SR + rangos
   - matchmaking premium
   - leaderboards

2. **PvP activity layer**
   - FFA
   - múltiples modos
   - múltiples kits
   - múltiples arenas
   - historial de peleas
   - layouts de kits

3. **Social + retention layer**
   - parties
   - party duels
   - friends
   - perfiles públicos
   - settings por usuario
   - eventos hosteados por jugadores con rango
   - progresión social

En resumen: el producto no es un plugin chico. Es una **plataforma Practice PvP competitiva y social**, con foco fuerte en calidad de matchmaking, ranking y experiencia del jugador.

---

## Modelo recomendado de primer login del jugador

### Decisión general

La mejor decisión para este proyecto es un modelo **híbrido**:

- **perfil base + settings + contexto mínimo** creados en el primer login
- **datos específicos por modo/sistema** creados de forma **lazy** cuando realmente se usan

### Por qué esta es la mejor decisión

Porque el proyecto quiere:

- mucha flexibilidad en modos
- posibilidad de agregar ladders nuevas sin dolor
- buena arquitectura
- evitar estructuras vacías innecesarias

Si creáramos SR, stats y layouts para todos los modos desde el primer login, acoplaríamos el bootstrap del jugador al catálogo completo de modos. Eso es mala base para un sistema que justamente quiere poder crecer y cambiar modos con facilidad.

### Qué debe existir sí o sí desde el primer login

#### 1. Practice Player Profile base

Debe persistirse un perfil base del jugador con al menos:

- uuid
- nombre actual
- nombre normalizado si hace falta para búsqueda
- first seen
- last seen
- metadata básica del perfil

#### 2. Settings por defecto

El jugador debe nacer con settings completas por defecto, al menos para:

- chat enabled = **ON**
- duel requests enabled = **ON**
- friends-only duels enabled = **OFF**
- friend requests enabled = **ON**
- spectate enabled = **ON**
- lobby players visible = **ON**
- party requests enabled = **ON**
- event alerts enabled = **ON**
- scoreboard enabled = **ON**
- ping range = **Within 100ms of you**

Esto evita ambigüedad y hace que el jugador ya tenga una configuración consistente desde su primer ingreso.

### Por qué el Ping Range por defecto debe ser Within 100ms of you

La recomendación inicial es **Within 100ms of you** porque es el mejor equilibrio entre:

- calidad de match
- tiempos de cola razonables
- competitividad sana

#### Por qué no `No Limit`

Porque como default degrada demasiado la calidad competitiva y puede generar primeras experiencias injustas o muy inconsistentes.

#### Por qué no 25ms o 50ms

Porque como default puede ser demasiado estricto para mucha gente y romper innecesariamente la velocidad de cola.

#### Por qué 100ms sí

Porque como punto de partida:

- protege mejor la experiencia competitiva
- sigue siendo razonable para matchmaking inicial
- permite que el jugador estricto baje el rango manualmente
- permite que el jugador más flexible lo amplíe si quiere

#### 3. Contexto de season base

Como habrá seasons desde la primera gran fase, el perfil del jugador debe poder quedar asociado a la season actual, aunque sus datos competitivos específicos nazcan más tarde.

#### 4. Presencia / sesión actual

En hot-state (Redis o equivalente) debe existir el estado operativo actual del jugador, por ejemplo:

- online/offline
- runtime actual
- server actual
- estado general (hub, queue, match, ffa, etc.)

### Qué debe crearse lazy cuando se use

#### 1. SR por modo

El SR por modo debe crearse cuando el jugador use competitivamente ese modo por primera vez.

No conviene crear SR para todos los modos apenas entra, porque:

- hay muchos modos
- pueden aparecer modos nuevos
- ranked es por modo
- no todos los jugadores tocarán todos los ladders

#### 2. Rango por modo

El rango por modo nace naturalmente junto al SR de ese modo.

#### 3. Stats por modo/sistema

Las estadísticas específicas deben nacer cuando el jugador participa en ese sistema:

- ranked stats del modo X
- unranked stats del modo X
- FFA stats
- event stats
- social stats específicas si aplican

#### 4. Layouts de kits

Los layouts deben crearse cuando el jugador use o edite ese kit por primera vez.

Esto tiene mucho más sentido que crear layouts vacíos para todos los modos desde el primer ingreso.

#### 5. Datos específicos de eventos / FFA / sistemas secundarios

Todo registro ultra específico de eventos, FFA público o mecánicas secundarias debe aparecer cuando el jugador realmente interactúe con esas features.

### Qué NO debería persistirse como perfil pesado inicial

No conviene crear desde el primer login:

- SR de todos los modos
- stats de todos los modos
- layouts de todos los kits
- registros vacíos de cada sistema posible
- party state persistente sin uso real

### Conclusión arquitectónica

La decisión correcta para Practice es:

- **perfil base temprano**
- **defaults claros desde el primer ingreso**
- **datos competitivos y específicos creados bajo demanda**

Eso mantiene la arquitectura limpia, flexible y preparada para crecer sin inflar la base de datos con ruido.

---

## Flujo principal ideal del jugador

Se definió un flujo principal muy claro para el uso más frecuente del producto.

### Entrada al Hub

Cuando el jugador entra a Practice, tendrá aproximadamente **7 items principales** en el inventario/hotbar del lobby.

Ejemplo de distribución mencionado:

- **Slot 1** → item de **Queue Unranked**
- **Slot 2** → item de **Queue Ranked**
- **Slot 3** → item para abrir menú de **FFA** y seleccionar modo / ir al servidor FFA
- **Slot 5** → item para **crear una party**
- **Slot 7** → item de **Leaderboards**
- **Slot 8** → item de **Cosméticos**
- **Slot 9** → menú general con acciones como:
  - estadísticas
  - settings
  - match history
  - kit editor

### Flujo principal competitivo

El flujo principal esperado es:

1. el jugador entra a Practice
2. llega al hub con sus items principales
3. elige **Ranked** o **Unranked**
4. se abre un menú con los diferentes modos/kits
5. selecciona, por ejemplo, **Sword**
6. entra a la cola
7. se ejecuta la lógica de matchmaking
8. el matchmaking considera factores que después se definirán mejor, como:
   - ping configurado por el usuario
   - rangos/SR
   - otros criterios del sistema
9. cuando encuentra match, el jugador es enviado al servidor de **Match** con todos los datos necesarios
10. se juega la partida, por ejemplo un **mejor de 3**
11. se determina el ganador
12. se entrega el link/resumen del match
13. se guardan los datos del combate
14. el jugador vuelve al hub
15. puede volver a jugar inmediatamente

### Otros flujos secundarios importantes

Además del flujo principal competitivo, el jugador también puede:

- ir al **FFA**
- hacer **party** con amigos u otros jugadores
- jugar **party duels**
- participar en **torneos/eventos hosteados por usuarios**
- revisar estadísticas, historial y settings

### Conclusión del flujo

Esto confirma algo MUY importante para la arquitectura:

- el **Hub** es la puerta central del sistema
- **Ranked/Unranked + matchmaking + match transfer** son el flujo principal más crítico
- FFA, social y eventos son importantes, pero orbitan alrededor de esa entrada principal
