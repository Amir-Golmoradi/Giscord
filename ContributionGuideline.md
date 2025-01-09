# Giscord Contribution Guidelines

## Getting Started

### Setting Up Your Development Environment
1. Fork the Giscord repository
2. Clone your fork: `git clone https://github.com/YOUR-USERNAME/giscord`
3. Add the main repository as upstream: `git remote add upstream https://github.com/giscord/giscord`

### Git Workflow
1. Always create a new branch for your work:
   ```bash
   git checkout -b feature/your-feature-name
    #or
   git checkout -b fix/your-fix-name
   ```

2. Keep your branch updated:
   ```bash
   git fetch upstream
   git rebase upstream/main
   ```

3. Make small, focused commits:
   ```bash
   git add specific-file.kt
   git commit -m "feat: add giscordUser presence tracking"
   ```

### Commit Message Guidelines
We use conventional commits to make our history clear:
- `feat:` for new features
- `fix:` for bug fixes
- `docs:` for documentation changes
- `refactor:` for code improvements
- `test:` for adding tests

## Code Quality Guidelines

### Structure
- Keep files under 300 lines
- One class per file
- Use meaningful package names
- Group related functionality together

### Kotlin Best Practices
- Use data classes for models
- Prefer immutability (use `val` over `var`)
- Use coroutines for async operations
- Write extension functions for clean APIs

### Testing
- Write unit tests for new features
- Maintain test coverage above 80%
- Test both success and failure cases
- Mock external dependencies

## Review Process
1. Open a Pull Request (PR) to the `main` branch
2. Wait for code review
3. Address feedback if requested
4. Maintain a clean commit history

## Documentation
- Update README.md if needed
- Add KDoc comments to public APIs
- Include example usage in documentation
- Write clear commit messages

## Need Help?
- Check existing issues and PRs
- Ask questions in discussions
- Join our Discord community
- Read our documentation

Remember: Every contribution matters, no matter how small!