# Gimnasio con Membresías y Rutinas (Java)

## Versión
**1.0.0**

## Descripción
Sistema de gimnasio con membresías y rutinas desarrollado en Java. Permite gestionar membresías (Básica, Premium, VIP, Estudiante, Corporativa) y rutinas de ejercicio (Cardio, Fuerza, Crossfit), demostrando herencia y polimorfismo con dos jerarquías.

## Alcance

### ✅ Qué hace
- Gestionar diferentes tipos de membresías (Básica, Premium, VIP, Estudiante, Corporativa)
- Calcular costo mensual según el tipo de membresía
- Gestionar diferentes tipos de rutinas (Cardio, Fuerza, Crossfit)
- Calcular calorías estimadas y duración de rutinas
- Asignar clientes a entrenadores
- Registrar visitas y controlar aforo
- Generar facturas de membresía
- Demostrar polimorfismo con lista de tipo `Membresia` y lista de tipo `RutinaEjercicio`

### ❌ Qué NO hace
- No tiene interfaz gráfica (solo consola)
- No procesa pagos reales

## Jerarquía de Membresías

| Clase | Tipo | Descripción | Costo mensual |
|-------|------|-------------|---------------|
| `Membresia` | Abstracta | Clase base con atributos comunes | - |
| `MembresiaBasica` | Hija | Acceso limitado a sala de pesas | $35,000 + mantenimiento |
| `MembresiaPremium` | Hija | Acceso a todas las áreas | $75,000 |
| `MembresiaVIP` | Hija | Beneficios exclusivos | $120,000 + bono |
| `MembresiaEstudiante` | Hija | Descuento especial para estudiantes | 60% del costo base |
| `MembresiaCorporativa` | Hija | Para empresas con múltiples empleados | Base - descuento volumen |

## Jerarquía de Rutinas

| Clase | Tipo | Descripción | Duración |
|-------|------|-------------|----------|
| `RutinaEjercicio` | Abstracta | Clase base de rutinas | - |
| `RutinaCardio` | Hija | Ejercicios cardiovasculares | 45 min |
| `RutinaFuerza` | Hija | Ejercicios de fuerza con pesas | 60 min |
| `RutinaCrossfit` | Hija | Entrenamiento funcional de alta intensidad | 50 min |

## Niveles de Rutina

| Nivel | Descripción |
|-------|-------------|
| PRINCIPIANTE | Para personas que inician en el ejercicio |
| INTERMEDIO | Para personas con experiencia media |
| AVANZADO | Para personas con alto rendimiento |

## Estados de Pago

| Estado | Descripción |
|--------|-------------|
| AL_DÍA | Pago al día |
| ATRASADO | Pago vencido |
| SUSPENDIDO | Membresía suspendida por falta de pago |

## Documentación Javadoc
[https://mpfx.github.io/GimnasioMembresiasJava/](https://mpfx.github.io/GimnasioMembresiasJava/)

## Tecnologías
- Java 17+
- Javadoc
- GitHub Pages

## Modo de uso
**Este proyecto NO es una aplicación visual/gráfica.**
Funciona exclusivamente por consola (CLI - Command Line Interface).

## Propósito
**Educativo / Pedagógico**
- Programación orientada a objetos en Java
- Herencia y polimorfismo
- Clases abstractas
- Dos jerarquías independientes
- Gestión de membresías y rutinas
- Facturación y control de pagos
- Documentación técnica con Javadoc
- Control de versiones con Git y GitHub Pages

## Autor
**ISC Israel de Jesús Mar Parada (MPFx++)**

## Derechos de autor
**© 2024 ISC Israel de Jesús Mar Parada (MPFx++)**
Todos los derechos reservados.

Este proyecto ha sido desarrollado exclusivamente con fines educativos.

---

**Nota:** Este proyecto es parte de una serie de 12 proyectos educativos para la enseñanza de herencia y polimorfismo en Java.
