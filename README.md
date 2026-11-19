# Agenda de actividades en Kotlin Multiplatform

Proyecto de Desarrollo de Software IV de David Mora Gómez (C5H441), Herlin Fabian Chavarria Beita (C5E187) y Vladimir Sancho Venegas (C37378), Universidad de Costa Rica, Sede del Pacífico.

La aplicación permite consultar y registrar actividades con título, fecha en formato `AAAA-MM-DD` y descripción. Antes de guardar valida que los campos tengan la longitud mínima y que la fecha exista en el calendario (incluyendo años bisiestos), muestra mensajes de error debajo de cada campo cuando hace falta y agrega la actividad nueva al inicio de la lista con un aviso de confirmación.

## 1. Requisitos e instalación

Para compilar y probar el proyecto hace falta contar con JDK 21 instalado en el sistema. No es necesario instalar Gradle por separado, porque el repositorio incluye el script `gradlew.bat` (y `gradlew` para macOS o Linux), el cual descarga la versión configurada la primera vez que se ejecuta.

Para trabajar con la versión de Android se necesita Android Studio y el SDK de Android (plataforma 37, con `minSdk` 24). La ruta local del SDK se indica en un archivo `local.properties` en la raíz del proyecto con una línea como `sdk.dir=C:/ruta/al/Android/Sdk`. Para compilar y ejecutar la versión de iOS se requiere una computadora con macOS y Xcode instalado.

## 2. Comandos de ejecución

Desde la carpeta raíz del proyecto, en una terminal de Windows con JDK 21:

```powershell
# Ejecutar la aplicación de escritorio (Windows, macOS o Linux)
.\gradlew.bat :desktopApp:run

# Ejecutar las pruebas unitarias del módulo compartido
.\gradlew.bat :shared:jvmTest

# Generar el APK de depuración para Android
.\gradlew.bat :androidApp:assembleDebug

# Ejecutar la versión web con Kotlin/Wasm en el navegador
.\gradlew.bat :webApp:wasmJsBrowserDevelopmentRun
```

El archivo APK generado para Android queda disponible en `androidApp/build/outputs/apk/debug/`.

## 3. Estructura del proyecto

El repositorio separa la lógica e interfaz compartida de los puntos de entrada específicos de cada plataforma:

```text
Kotlin-Multiplatform/
├─ gradle/libs.versions.toml
├─ shared/
│  └─ src/
│     ├─ commonMain/kotlin/org/ucr/agenda/
│     │  ├─ Activity.kt              # Modelos de datos y validación de campos y fechas
│     │  ├─ ActivityStore.kt         # Estado observable en memoria (mutableStateListOf)
│     │  ├─ ActivityListScreen.kt    # Pantalla principal con listado de tarjetas
│     │  ├─ ActivityFormScreen.kt    # Formulario de registro y validación visual
│     │  └─ App.kt                   # Tema Material 3 y navegación tipada (NavHost)
│     ├─ commonTest/kotlin/org/ucr/agenda/
│     │  └─ ActivityValidationTest.kt
│     └─ iosMain/kotlin/org/ucr/agenda/
│        └─ MainViewController.kt
├─ androidApp/src/main/kotlin/org/ucr/agenda/MainActivity.kt
├─ desktopApp/src/main/kotlin/org/ucr/agenda/main.kt
├─ webApp/src/webMain/kotlin/org/ucr/agenda/main.kt
└─ iosApp/iosApp.xcodeproj
```

3.1. Módulo `shared`: concentra los modelos (`ActivityItem`, `ActivityDraft`, `FormErrors`), la función `validateActivity`, el almacén reactivo `ActivityStore`, las dos pantallas hechas con Compose Multiplatform y las pruebas unitarias en `commonTest`.

3.2. Módulo `androidApp`: punto de entrada en Android mediante `MainActivity.kt`, que inicia el componente común `App()`.

3.3. Módulo `desktopApp`: punto de entrada en escritorio mediante `main.kt`, que abre una ventana nativa de Compose Desktop titulada `Agenda KMP`.

3.4. Módulo `webApp`: arranque para navegador web mediante `ComposeViewport`.

3.5. Carpeta `iosApp`: proyecto de Xcode que conecta la interfaz de iOS con `MainViewController.kt`.

## 4. Limitaciones actuales

4.1. Almacenamiento en memoria: las actividades se guardan en `ActivityStore` durante la sesión activa, por lo que al cerrar la aplicación la lista vuelve a las dos actividades iniciales de demostración.

4.2. Compilación para iOS: aunque el código compartido y `MainViewController.kt` están configurados en el repositorio, generar el binario para iPhone o el simulador de iOS exige ejecutar Xcode desde macOS.

4.3. Pruebas de escritorio y entorno local: la ejecución funcional completa se verificó en Windows mediante `:desktopApp:run`; la ejecución en Android depende de tener configurado `local.properties` con el SDK 37.

La base inicial del proyecto parte de la [plantilla oficial de Kotlin Multiplatform](https://github.com/Kotlin/KMP-App-Template) bajo la licencia Apache 2.0 incluida en `LICENSE`.
