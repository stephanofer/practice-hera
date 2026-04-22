# Practice Hera — Catálogo inicial de modos de salida

## Propósito

Cerrar uno de los pendientes más importantes antes de empezar el desarrollo fuerte:

- definir qué modos van a formar parte del catálogo inicial real de salida

Este documento NO define toda la vida futura del producto.
Define el **primer catálogo activo recomendado** con el que conviene arrancar para mantener:

- identidad competitiva fuerte
- variedad suficiente
- complejidad controlada
- buena base para escalar después

---

## Criterios usados para decidir

El catálogo inicial se eligió con estos criterios:

1. **Cobertura de estilos PvP distintos**
   - melee limpio
   - axe combat
   - healing/resource management
   - crystal/high skill ceiling
   - supervivencia táctica

2. **Valor competitivo real**
   - modos que sí sostienen ranked/unranked y retención

3. **Compatibilidad con la arquitectura base ya definida**
   - modes reutilizables
   - queues separadas
   - rules configurables
   - historial y stats por modo

4. **No meter modos especiales prematuramente**
   - Sumo, Boxing, Bridge, Dropped y Parkour siguen siendo importantes, pero no conviene ponerlos en el primer bloque competitivo base si todavía requieren comportamiento más especial o framework separado

---

## Decisión final recomendada — catálogo activo inicial

Estos son los modos que recomiendo dejar como **catálogo activo inicial de salida**.

### 1. Sword

#### Por qué entra
- es el modo más claro para representar el núcleo competitivo base
- sirve como referencia general del Practice
- funciona muy bien para ranked y unranked
- tiene excelente valor para historial, stats y leaderboard

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ✅
- party FFA ✅
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**

---

### 2. Axe

#### Por qué entra
- da variedad real de combate competitivo
- aporta otra expresión de skill sin salirse del núcleo PvP serio
- ayuda a que el Practice no se sienta monocorde

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ❌ inicialmente
- party FFA ✅ si luego se quiere como variante controlada
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**

---

### 3. BuildUHC

#### Por qué entra
- agrega un estilo muy reconocible y popular
- obliga a validar bien rules, arena/environment capabilities y stats relevantes
- es excelente para probar la robustez del diseño base

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ✅
- party FFA ✅
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**

---

### 4. CrystalPvP

#### Por qué entra
- tiene muchísimo valor aspiracional y competitivo
- sube el techo de skill del servidor
- ayuda al posicionamiento de Practice como algo serio y actual

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ✅
- party FFA ✅
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**, aunque exige stats y tuning más finos que Sword/Axe

---

### 5. Pot

#### Por qué entra
- aporta identidad clásica de practice serio
- justifica bien stats específicas como pot accuracy y heals used
- agrega profundidad distinta a los modos melee directos

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ❌ inicialmente
- party FFA ✅ opcional más adelante
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**

---

### 6. SMP

#### Por qué entra
- aporta una capa más survival/táctica al catálogo competitivo
- ayuda a no encerrar el producto solo en combate ultracorto de arena clásica
- conecta bien con la visión de variedad dentro del ecosistema Practice

#### Contextos recomendados
- ranked ✅
- unranked ✅
- public FFA ❌ inicialmente
- party FFA ✅ si se valida bien la experiencia
- party duel ✅
- hosted events ✅

#### Naturaleza
- **modo base configurable**

---

## Catálogo preparado pero NO activo en el primer bloque

Estos modos tienen sentido dentro del ecosistema, pero no recomiendo meterlos como primer catálogo activo base.

### Preparados como expansión de modos base
- NetheriteOP
- DiamondSMP
- Mace

#### Por qué no de salida inmediata
- suman valor, sí
- pero no son tan necesarios como los seis seleccionados para validar la base principal
- conviene activarlos una vez que el sistema base ya esté respirando bien

---

## Modos especiales importantes, pero no parte del primer bloque competitivo base

### Especiales / de tratamiento distinto
- Sumo
- Boxing
- Bridge
- Dropped
- Parkour

#### Por qué no los mezclo en el primer catálogo base
- tienen comportamiento suficientemente especial como para merecer su propio tratamiento
- algunos encajan mejor como special modes o event types que como ladder base principal
- meterlos demasiado pronto ensucia el primer bloque de implementación

---

## Lectura estratégica de esta decisión

El catálogo inicial recomendado queda compuesto por:

- **Sword**
- **Axe**
- **BuildUHC**
- **CrystalPvP**
- **Pot**
- **SMP**

### Qué nos da este catálogo
- núcleo competitivo fuerte
- variedad real sin caos
- suficientes casos para validar rating, queueing, rules, arenas, historial y stats
- base sana para expandir a otros modos después

### Qué evita
- salir con demasiados modos poco diferenciados
- inflar la complejidad inicial
- meter modos especiales antes de tener firme el esqueleto del sistema

---

## Conclusión

La decisión correcta para el primer catálogo activo no es “meter todos los modos posibles”.

La decisión correcta es arrancar con un set que:

- represente bien la identidad competitiva del producto
- valide la arquitectura
- permita crecer después sin dolor

Por eso, el catálogo inicial recomendado de salida queda en:

- Sword
- Axe
- BuildUHC
- CrystalPvP
- Pot
- SMP
