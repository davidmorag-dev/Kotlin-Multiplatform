<<<<<<< HEAD
# Kotlin Multiplatform — estructura inicial

Proyecto del equipo de Desarrollo de Software IV, Universidad de Costa Rica, Sede del Pacífico.

**Integrantes:** David Mora Gómez, Herlin Fabian Chavarria Beita y Vladimir Sancho Venegas.

Esta rama contiene únicamente la base del proyecto. La aplicación de agenda completa se conserva por separado en la carpeta `Codigo Kotlin completo` del Escritorio como referencia. Las funcionalidades se incorporarán mediante las ramas `David`, `Herlin` y `Vladimir`.

## Módulos

| Carpeta | Propósito |
| --- | --- |
| `shared` | Código y futura interfaz compartidos; contiene una pantalla de arranque mínima. |
| `androidApp` | Entrada y recursos de Android. |
| `desktopApp` | Entrada de escritorio. |
| `webApp` | Entrada web. |
| `iosApp` | Proyecto de iOS para abrir en macOS con Xcode. |

En `shared/src/commonMain/kotlin/org/ucr/agenda` están preparadas las carpetas `model`, `data`, `validation`, `ui/screens` y `ui/navigation`. `shared/src/commonTest` queda reservado para pruebas.

## Entorno

- JDK 21.
- Gradle Wrapper incluido; descarga Gradle y las dependencias Kotlin/Compose al compilar.
- Para Android: SDK Platform 37.0, Build Tools y Platform Tools. El SDK puede ubicarse fuera del repositorio y apuntarse desde `local.properties` con `sdk.dir`.
- Para iOS: macOS y Xcode. No se requiere para la demostración en Windows.

## Comprobación inicial

En Windows, con JDK 21 seleccionado:

```powershell
.\gradlew.bat :shared:compileKotlinJvm :desktopApp:compileKotlin
.\gradlew.bat :androidApp:assembleDebug
```

La estructura inicial compiló el 7 de noviembre de 2026 para JVM/escritorio, web (`:webApp:compileKotlinJs`) y Android (`:androidApp:assembleDebug`). El APK de prueba se genera en `androidApp/build/outputs/apk/debug/`.

En el equipo donde se preparó el proyecto, Android Studio está en `%LOCALAPPDATA%/KotlinMultiplatform/tools/android-studio` y el SDK en `%LOCALAPPDATA%/KotlinMultiplatform/android-sdk`. `local.properties` apunta al SDK y permanece fuera de Git para no imponer esa ruta a los demás integrantes.

La base procede de la [plantilla oficial Kotlin Multiplatform](https://github.com/Kotlin/KMP-App-Template). El equipo conservará la atribución y licencia Apache 2.0 de la plantilla.
=======
# Agenda en Kotlin Multiplatform

Este es el proyecto que estamos haciendo David, Herlin y Vladimir para Desarrollo de Software IV de la UCR, Sede del Pacífico. Vamos a hacer una agenda que pueda usarse en varias plataformas con Kotlin Multiplatform.

Por ahora, `main` tiene la base del programa. Cada uno va trabajando en su rama (`David`, `Herlin` o `Vladimir`) y al final juntaremos las partes.

## Qué hay en cada carpeta

- `shared`: aquí va el código que pueden usar todas las versiones de la app. La base ya trae una pantalla sencilla y carpetas preparadas para modelos, datos, validaciones y pantallas.
- `androidApp`: arranque y recursos de Android.
- `desktopApp`: arranque de la versión para computadora.
- `webApp`: arranque de la versión web.
- `iosApp`: proyecto para abrir la app en una Mac con Xcode.

## Qué se necesita

- JDK 21.
- Android Studio y el SDK de Android si vas a trabajar con esa versión. El proyecto usa la plataforma 37.
- Una Mac con Xcode si vas a probar iOS. Eso no hace falta para trabajar en Windows con Android, escritorio o web.

No hay que instalar Gradle a mano: el proyecto ya trae `gradlew.bat`, que descarga lo necesario la primera vez que se ejecuta. El SDK de Android se configura en un archivo `local.properties` dentro del repositorio con una línea como `sdk.dir=C:/ruta/al/Android/Sdk`. Ese archivo es distinto en cada computadora y por eso no se sube a GitHub.

## Cómo comprobar la base

Desde la carpeta del repositorio, en una terminal de Windows con JDK 21:

```powershell
.\gradlew.bat :shared:compileKotlinJvm :desktopApp:compileKotlin
.\gradlew.bat :webApp:compileKotlinJs
.\gradlew.bat :androidApp:assembleDebug
```

El APK de prueba queda en `androidApp/build/outputs/apk/debug/`. El 7 de noviembre de 2026 comprobamos que la base compilaba para escritorio, web y Android. Conforme agreguemos las partes de la agenda habrá que volver a correr estos comandos.

La estructura salió de la [plantilla oficial de Kotlin Multiplatform](https://github.com/Kotlin/KMP-App-Template). Su licencia Apache 2.0 está en `LICENSE`.
>>>>>>> 0fc0773b54483dfe4e00a54c3ab8401d3284c79f
