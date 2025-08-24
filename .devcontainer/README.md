# Java 21 Maven Development Container

This devcontainer configuration provides a complete development environment for Java 21 projects using Maven.

## Features

- **Java 21**: Latest LTS version of Java
- **Maven**: Latest version of Apache Maven
- **VS Code Extensions**: Pre-configured Java development extensions
- **Development Tools**: Git, curl, wget, vim, nano, tree, htop
- **Maven Optimization**: Configured Maven settings for better performance
- **Volume Mounting**: Maven repository is mounted for faster builds

## Getting Started

1. **Prerequisites**: 
   - Docker Desktop installed and running
   - VS Code with the "Dev Containers" extension

2. **Open in Container**:
   - Open this project in VS Code
   - When prompted, click "Reopen in Container" or use `Ctrl+Shift+P` and select "Dev Containers: Reopen in Container"

3. **First Run**:
   - The container will build automatically
   - Maven dependencies will be downloaded on first build
   - The project will be compiled with `mvn clean install -DskipTests`

## Available Commands

Once inside the container, you can use:

```bash
# Build the project
mvn clean install

# Run tests
mvn test

# Run specific test class
mvn test -Dtest=TestClassName

# Clean and compile
mvn clean compile

# Run with specific profile
mvn clean install -Pprofile-name
```

## Configuration

### Java Settings
- Java 21 with automatic configuration updates
- Google Style formatting
- Automatic import organization
- Null analysis enabled

### Maven Settings
- Local repository: `/home/vscode/.m2/repository`
- Non-interactive mode
- Optimized for development

### VS Code Extensions
- Java Extension Pack
- Maven for Java
- Java Debug
- Java Test Runner
- Java Dependency Viewer

## Troubleshooting

### Build Issues
If you encounter build issues:
1. Clean Maven cache: `mvn dependency:purge-local-repository`
2. Rebuild container: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

### Performance Issues
- Maven repository is mounted as a volume for faster subsequent builds
- Consider increasing Docker memory allocation if needed

### Port Forwarding
Add any required ports to the `forwardPorts` array in `devcontainer.json` if your application needs to expose ports.

## Customization

You can customize this setup by:
- Modifying the `Dockerfile` to add more tools
- Updating VS Code extensions in `devcontainer.json`
- Adding environment variables or build arguments
- Configuring additional Maven settings 