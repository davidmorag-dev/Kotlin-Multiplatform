# Kotlin Multiplatform — estructura inicial

Proyecto del equipo de Desarrollo de Software IV, Universidad de Costa Rica, Sede del Pacífico.

**Integrantes:** David Mora Gómez, Herlin Fabian Chavarria Beita y Vladimir Sancho Venegas.

Esta rama contiene únicamente la base del proyecto. La aplicación de agenda completa se conserva por separado en la carpeta vecina `Codigo Kotlin completo` como referencia. Las funcionalidades se incorporarán mediante las ramas `David`, `Herlin` y `Vladimir`.

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

En el equipo donde se preparó el proyecto, Android Studio está en la carpeta vecina `.tools/android-studio` y el SDK en `.android-sdk`. `local.properties` apunta al SDK y permanece fuera de Git para no imponer esa ruta a los demás integrantes.

La base procede de la [plantilla oficial Kotlin Multiplatform](https://github.com/Kotlin/KMP-App-Template). El equipo conservará la atribución y licencia Apache 2.0 de la plantilla.
