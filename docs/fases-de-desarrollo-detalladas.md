# Practice Hera — Fases de Desarrollo Detalladas

## Cómo vamos a usar este documento

Este archivo NO reemplaza la hoja de ruta.

La hoja de ruta define el orden macro.
Este documento define el detalle de cada fase mientras tomamos decisiones reales.

Regla simple:
- `docs/hoja-de-ruta-desarrollo.md` = visión y orden global
- `docs/fases-de-desarrollo-detalladas.md` = decisiones, alcance, entregables y checklist por fase

---

## Estado general

- Fase actual: **Fase 0 — Definir el lenguaje del negocio**
- Estado actual: **En definición**

---

## Fase 0 — Definir el lenguaje del negocio

### Objetivo
Definir con precisión qué producto estamos construyendo, qué problemas resuelve y cuáles son sus conceptos centrales.

### Por qué esta fase existe
Si no definimos bien el negocio, después terminamos inventando reglas a mitad de implementación. Eso destruye el orden, rompe el roadmap y genera acoplamiento innecesario.

### Lo que tiene que salir de esta fase
- glosario del negocio
- listado de funcionalidades base
- responsabilidades claras por runtime
- invariantes del sistema
- primera separación entre MVP, importante y opcional

### Preguntas que esta fase tiene que responder
- qué modos exactos va a soportar Practice en su primera versión
- cómo entra un jugador al sistema
- qué puede hacer un jugador en hub, match y ffa
- qué entidades existen realmente en el dominio
- qué reglas son globales y cuáles dependen del modo de juego
- qué cosas son obligatorias para el MVP y cuáles pueden esperar

### Entregables esperados
- [ ] glosario del negocio
- [x] captura inicial de visión y funcionalidades del producto (`docs/fase-0-definicion-producto.md`)
- [ ] inventario de funcionalidades priorizado
- [ ] responsabilidades por módulo/runtime
- [ ] invariantes core
- [ ] clasificación MVP / siguiente etapa / opcional

### Decisiones tomadas hasta ahora
- El proyecto se va a construir por fases, desde negocio y dominio hacia runtimes.
- No se va a empezar por features visuales ni por UI compleja.
- Si aparece una dependencia base no resuelta, se pausa la feature y se resuelve primero esa base.
- La visión actual del producto ya incluye ranked, unranked, series por rondas, SR con rangos, historial detallado de combates, múltiples arenas, múltiples kits/modos, FFA multimodo, leaderboards core, perfiles públicos, progresión social, parties, party duels, eventos hosteados por jugadores con rango, friends, settings por usuario, ping range y estadísticas globales en tiempo real.
- Todo ese alcance pertenece a la primera gran fase solicitada por cliente; internamente lo vamos a dividir en subfases por dependencias, no recortarlo fuera de fase.
- El flujo principal del jugador será Hub -> menú Ranked/Unranked -> selección de modo/kit -> cola -> matchmaking -> transferencia a Match -> serie/partida -> resumen guardado -> vuelta al Hub -> requeue.
- Los modos deben diseñarse con máxima flexibilidad: una capa de modos base configurables y otra de modos especiales con lógica propia solo cuando sea realmente necesario.
- El sistema de rules configurables será una base del diseño de modos, kits y comportamiento del match.
- Los player types serán configurables por modo.
- Ranked será solamente 1v1 en esta primera gran fase.
- FFA público será un sistema aparte con stats y comportamiento propios, pero podrá reutilizar modos, kits, layouts y rules del ecosistema Practice cuando convenga.
- Party FFA es parte del Practice y debe usar las piezas compartidas del Practice (modos, kits, layouts, rules, etc.) en lugar de inventar un sistema paralelo.
- El SR será por modo/ladder y además existirá un Global Rating calculado como promedio simple de todos los SR por modo.
- Existirá rango por modo y rango global.
- Habrá seasons desde esta primera gran fase.
- Recomendación inicial: placements sí, decay no al inicio, streak bonus de SR no al inicio.
- El sistema de seasons será simple: preparado para cortes manuales, con reset total inicial, conservación de histórico por season y all-time, y rewards entregados manualmente.
- El historial de match debe guardar metadata del match, datos por jugador, stats agregadas y eventos mínimos importantes.
- El inventario para historial/web se modelará con snapshot final exacto por slots; no se guardará snapshot inicial separado en esta etapa.
- Matchmaking recomendado: Ranked quality-first con expansión progresiva de búsqueda; Unranked speed-first usando SR como referencia más laxa; Ping Range del usuario tratado como preferencia fuerte y región elegida por mejor calidad común.
- Bootstrap recomendado de jugador: perfil base + settings + contexto mínimo en primer login; SR/stats/layouts/registros específicos creados lazy cuando el jugador usa cada modo o sistema.
- Defaults iniciales de settings: todo ON salvo 'solo duels de amigos' en OFF; Ping Range por defecto recomendado en 'Within 100ms of you'.
- Friends debe pensarse como capacidad de nivel red reutilizable entre modalidades, pero con dominio/persistencia compartidos fuera del ownership exclusivo del proxy; el proxy integra presencia y delivery cross-server.
- Política inicial de requests sociales definida: friend requests con autoaccept recíproco y expiración de 5 min; duel requests con expiración de 30s; party invites con expiración de 60s; todas con anti-spam, sin duplicados y respetando settings/estado del jugador.
- Party definida como herramienta social-operativa: un solo líder, transferencia manual fácil, capacidad configurable con ampliación por permisos, liderazgo automático al miembro elegible online más antiguo si el líder se va, y restricciones configurables para acciones individuales incompatibles.
- Eventos hosteados definidos como framework escalable basado en plantillas predefinidas, con configuración esencial por tipo (mapa/modo/kit/opciones básicas), orientados a una mezcla de retención social y prestigio competitivo.
- La entidad central 'Modo' quedó definida como una definición reusable de gameplay, con flags explícitas de uso y stats relevantes dependientes del modo.
- `Mode Definition` refinado en 10 bloques: identidad, capacidades, player types, kit/layout, match defaults, rule set, flags competitivas, stats relevantes, arena requirements y compatibilidad contextual.
- `Rule Definition` refinida como unidad declarativa reusable de comportamiento, con identidad, categoría, scope, activación, parámetros, contextos compatibles, fase de ejecución, conflictos, telemetría y visibilidad.
- El catálogo inicial oficial de rules será la lista exacta ya definida en Fase 0 y servirá como base del primer Rule System.
- `Queue Definition` definida como contexto de acceso y matchmaking separado de `Mode`, con identidad, tipo de cola, relación con modo, player type, política de matchmaking, restricciones de acceso/sociales, política de arena/región/runtime, impacto competitivo y visibilidad UX.
- `Match Session` definida como la ejecución real y auditable de una experiencia jugable materializada desde Queue + Mode, con configuración efectiva congelada, estados explícitos, soporte nativo de rounds/series, resultado competitivo, historial y paths de cancelación/falla.
- `Arena Definition` definida como contrato reusable y reservable de ejecución espacial, con clasificación, compatibilidad declarativa, región/runtime, puntos funcionales, requerimientos ambientales, estados operativos, reset/cleanup, rotación y telemetría.
- La creación/configuración de arenas debe incluir explícitamente `identifier`, `displayName`, `icon`, `universal region`, `battle region` y posiciones funcionales/spawns según el tipo de arena.
- `Player State System` definido con estado global principal único, subestados contextuales, transiciones explícitas y restricciones derivadas centralmente desde estado + settings + contexto.
- `Profile / Stats System` definido como capa separada de identidad pública, estado competitivo actual y proyecciones agregadas por dimensión (all-time, season, per-mode, social/activity), con leaderboards alimentados por proyecciones optimizadas.
- Data ownership definido con corte estricto: MySQL como fuente de verdad persistente y Redis como hot-state/coordinación rápida para presencia, colas, matches activos, requests efímeras, locks y counters vivos.
- Matriz operativa de ownership por entidad documentada para Profile, Settings, PlayerState, Presence, SR/Rank, Seasons, Friendships, Requests, Party, Queue, Match, Arena, Mode, Rule, Events, Leaderboards y Counters.
- Capa de Application Services definida con servicios explícitos y pequeños: Profile, PlayerState, Queue, Matchmaking, ArenaAllocation, Match, Rating, History, Friends, Party, DuelRequest, FFA, Event, LeaderboardProjection y StatsProjection.
- Persistencia concreta inicial definida con tablas MySQL recomendadas y namespaces/estructuras Redis recomendadas para hot-state, incluyendo ratings, settings, modes, rules, queues, arenas, matches, friendships, layouts, seasons, requests, counters y leaderboards.

### Decisiones pendientes
- Modos exactos de juego del MVP
- Tipos de cola del MVP
- Sistema de rating inicial exacto
- Alcance MVP de parties/social
- Alcance de temporadas
- Alcance de punishments/restricciones competitivas
- Alcance MVP de leaderboards
- Alcance MVP de eventos hosteados
- Alcance MVP del historial de match
- Alcance MVP de settings avanzados
- Límite exacto entre modo base configurable y modo especial con lógica propia
- Qué variantes no-ranked soportarán teams (2v2, 3v3, 4v4)
- Nombres finales e intervalos exactos de rangos
- Operativa exacta del corte manual de season y sus snapshots/reportes
- Thresholds exactos de expansión por tiempo para matchmaking
- Reglas exactas de restricciones configurables por estar en party
- Templates iniciales y límites exactos del framework de eventos hosteados
- Campos exactos y límites de la entidad Mode Definition
- Catálogo inicial y límites exactos del Rule System
- Campos exactos y límites de la entidad Queue Definition
- Campos exactos y límites de la entidad Match Session
- Campos exactos y límites de la entidad Arena Definition
- Campos exactos y límites del Player State System
- Campos exactos y límites del Profile / Stats System
- Ownership exacto por entidad entre MySQL y Redis
- Responsabilidades exactas y límites de cada Application Service
- Tablas MySQL exactas y claves Redis iniciales a validar antes de implementación

### Riesgos detectados
- Querer meter demasiadas features en la primera versión.
- Diseñar colas, kits o matches sin antes definir el comportamiento real del jugador.
- Mezclar reglas de negocio con UX de menú/plugin.
- Diseñar social, FFA o eventos sin asegurar primero el flujo principal hub -> queue -> match -> retorno.

---

## Fase 1 — Contratos compartidos y modelo de dominio

### Estado
Pendiente

### Se detallará cuando cierre Fase 0
- value objects
- identificadores
- enums
- contratos de servicios
- eventos de dominio
- reglas testables sin runtime

---

## Fase 2 — Persistencia y hot state

### Estado
Pendiente

### Se detallará cuando cierre Fase 1
- ownership de datos
- gateways/repositorios
- diseño MySQL
- diseño Redis
- locks/cooldowns/cache

---

## Fase 3 — Servicios de aplicación compartidos

### Estado
Pendiente

### Se detallará cuando cierre Fase 2
- profile service
- queue service
- matchmaking service
- arena allocation service
- presence service

---

## Fase 4 — Hub

### Estado
Pendiente

---

## Fase 5 — Match

### Estado
Pendiente

---

## Fase 6 — FFA

### Estado
Pendiente

---

## Fase 7 — Proxy

### Estado
Pendiente

---

## Fase 8 — Hardening

### Estado
Pendiente

---

## Convención para decidir cada fase

Cada fase que vayamos cerrando debería terminar con esto:

1. **Objetivo claro**
2. **Alcance exacto**
3. **Qué entra / qué no entra**
4. **Dependencias**
5. **Entregables**
6. **Riesgos**
7. **Decisiones tomadas**
8. **Preguntas abiertas**

Así evitamos avanzar con ambigüedad.
