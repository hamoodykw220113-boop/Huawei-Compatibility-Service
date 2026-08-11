name: Kotlin CI

on:
  push:
    branches: [ "main" ]
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - name: Checkout code
      uses: actions/checkout@v4

    - name: Setup JDK
      uses: actions/setup-java@v5
      with:
        java-version: '21'
        distribution: 'temurin'

    - name: Build with Gradle
      run: ./gradlew build

    - name: Run Tests
      run: ./gradlew test

    - name: Upload JAR
      uses: actions/upload-artifact@v4
      with:
        name: app-jar
        path: build/libs/*.jar
