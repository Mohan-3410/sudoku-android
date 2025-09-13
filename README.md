# Sudoku Android

A simple Android Sudoku game (Kotlin + Jetpack Compose) supporting multiple board sizes and difficulty levels.  
This repository contains a working prototype. The generator/solver uses a naive backtracking approach and the UI is a minimal Compose prototype.

---

## Table of Contents

- [Status](#status)  
- [Requirements](#requirements)  
- [Run in Android Studio (recommended)](#run-in-android-studio-recommended)  
- [Command-line build & install](#command-line-build--install)  
- [Run on a device/emulator](#run-on-a-deviceemulator)  
- [Change board size and difficulty](#change-board-size-and-difficulty)  
- [Troubleshooting](#troubleshooting)  
- [Limitations & Notes](#limitations--notes)  
- [Development ideas / Next steps](#development-ideas--next-steps)  
- [Contributing](#contributing)  
- [License](#license)

---

## Status

Working prototype (UI + generator/solver). Good starting point for improvements.
- Minimal Compose UI (tap cell to cycle value).
- Generator/solver: backtracking approach; assumes square sub-boxes (box width = sqrt(size)).

## Requirements

- Android Studio (recommended: Flamingo or newer)  
- JDK 17  
- Android SDK 34 (compile/target SDK configured to 34)  
- Gradle wrapper (project contains Gradle Kotlin DSL files)

## Run in Android Studio (recommended)

1. Clone the repository:
   ```
   git clone https://github.com/Mohan-3410/sudoku-android.git
   cd sudoku-android
   ```
2. Open Android Studio → "Open an existing project" → select the cloned folder.
3. If prompted, let Android Studio sync/upgrade the Gradle project.
4. Ensure Android Studio uses JDK 17:
   - File → Project Structure → SDK Location (or Settings → Build Tools → Gradle → Gradle JDK)
5. Create or start an emulator (AVD) targeting API 34, or connect a physical device with USB debugging.
6. Run the app (green ▶) or Run → Run 'app'. The app will build, install, and launch.

## Command-line build & install

(From the repo root; recommended to use the included Gradle wrapper)

- Assemble debug APK:
  ```
  ./gradlew assembleDebug
  ```
- Install debug APK on a connected device/emulator:
  ```
  ./gradlew installDebug
  ```
- Build a release (unsigned) APK:
  ```
  ./gradlew assembleRelease
  ```
  To sign a release APK you must configure signing config in `app/build.gradle.kts` (keystore, passwords).

If you don't have the Gradle wrapper, install a compatible Gradle locally (Gradle 8.x for AGP 8.1.0) and run `gradle assembleDebug`.

## Run on a device/emulator using adb

1. Start an emulator or plug in a device.
2. Install the APK:
   ```
   adb install -r app/build/outputs/apk/debug/app-debug.apk
   ```
3. Start the app (if not auto-started); replace package with yours if changed:
   ```
   adb shell am start -n com.mohan.sudoku/.MainActivity
   ```

## Change board size and difficulty

The default startup is set in `MainActivity.kt`:

```kotlin
val game = SudokuGenerator.generate(9, Difficulty.Easy)
```

- To change board size change the first parameter (e.g., 4, 9, 16).
- To change difficulty use `Difficulty.Medium`, `Difficulty.Hard`, or `Difficulty.Expert`.

Note: the generator currently computes sub-box size as sqrt(n) (so it works for sizes that are perfect squares such as 4, 9, 16). Non-perfect-square sizes (like 6 or 12) are not fully supported with correct box shapes in the current implementation.

## Troubleshooting

- Gradle sync errors: ensure JDK 17 and Android SDK 34 are installed. Use the Gradle wrapper bundled with the project.
- `Could not find com.android.tools.build:gradle:8.1.0` — update Android Studio or use the Android Studio bundled plugin/Gradle.
- Runtime crashes or Compose version mismatches: verify Compose and Kotlin plugin versions in `app/build.gradle.kts` match your Android Studio environment.
- If the app fails to install: ensure Developer Options and USB debugging are enabled on physical device; check `adb devices`.

## Limitations & Notes

- Generator/Solver:
  - Uses naive backtracking; adequate for prototypes and 9x9 boards.
  - Assumes square sub-boxes (box width = sqrt(size)); non-square box boards (6x6, 12x12) are not supported properly yet.
- UI:
  - Tap-to-cycle is a simple input method. No pencil-notes, undo, or sophisticated validation implemented.
- No unit tests or CI included in the prototype (yet).

## Development ideas / Next steps

- Support rectangular sub-box shapes (e.g., 6x6 with 2x3 boxes).
- Replace tap-to-cycle with a number pad and add pencil notes.
- Add validation, row/column/box highlighting, hints, and a solver button.
- Add unit tests for generator/solver and integrate GitHub Actions CI.
- Add telemetry or analytics and localization.

## Contributing

Contributions welcome. Suggested workflow:

1. Fork or create a branch:
   ```
   git checkout -b feature/your-feature
   ```
2. Make changes, run the app, and add tests if applicable.
3. Commit and push:
   ```
   git add .
   git commit -m "feat: short description"
   git push origin feature/your-feature
   ```
4. Open a pull request from your branch to `main`.

## How to update this README locally and push

1. Edit README.md locally (your editor/IDE).
2. Commit and push:
   ```
   git add README.md
   git commit -m "docs: improve README with run instructions"
   git push origin main
   ```
   (Prefer creating a branch and opening a pull request instead of pushing directly to main.)

If you prefer the web UI: open the repository on GitHub → click README.md → click the pencil (edit) icon → edit and commit.

## License

No license file included in this prototype. Add a LICENSE file if you plan to publish under a specific license.

---
