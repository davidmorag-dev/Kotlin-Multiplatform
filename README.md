# Agenda de actividades

Proyecto de Desarrollo de Software IV de David Mora Gómez, Herlin Fabian Chavarria Beita y Vladimir Sancho Venegas (UCR, Sede del Pacífico).

La app permite ver y agregar actividades con título, fecha y descripción. Revisa los datos antes de guardar y muestra la actividad nueva en la lista. Por ahora todo queda en memoria: al cerrar la app, se reinicia.

## Para probarla

Necesitas JDK 21. En Windows, desde la carpeta del proyecto:

```powershell
.\gradlew.bat :shared:jvmTest
.\gradlew.bat :desktopApp:run
```

Para Android hace falta el SDK 37 y configurar su ruta en `local.properties` (`sdk.dir=C:/ruta/al/Android/Sdk`). Luego puedes generar el APK con `.\gradlew.bat :androidApp:assembleDebug`. Para web usa `.\gradlew.bat :webApp:wasmJsBrowserDevelopmentRun`. iOS requiere una Mac con Xcode.

La base del proyecto viene de la [plantilla oficial de Kotlin Multiplatform](https://github.com/Kotlin/KMP-App-Template); su licencia Apache 2.0 está en `LICENSE`.
