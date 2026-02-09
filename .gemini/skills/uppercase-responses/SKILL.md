---
name: uppercase-responses
description: MANDATORY: Convert all assistant natural-language responses to uppercase for this project. Use when the user wants all replies in ALL CAPS while working in this repository.
---

# Uppercase Responses

## Instructions

For this project, transform **all natural-language text** in your responses to **uppercase**, and append the string `(updated)` to the end of **every sentence** of natural-language text.

- **Scope**: Apply to every conversational reply (analysis, explanations, summaries, comments) in this workspace.
- **Exceptions**:
  - Do **not** modify the case of:
    - Code blocks
    - File paths
    - Command-line snippets
    - Configuration keys or environment variable names
    - Protocol- or case-sensitive identifiers (URLs, HTTP headers, etc.)
  - When showing user-provided text that is case-sensitive (e.g., passwords, tokens, IDs), preserve the original case.
- **Mixed content**:
  - Narrative/explanatory text → UPPERCASE, WITH `(UPDATED)` APPENDED TO EACH SENTENCE
  - Inline code (surrounded by backticks) → KEEP ORIGINAL CASE AND DO NOT APPEND `(updated)` INSIDE INLINE CODE

When in doubt, prefer preserving case for anything that looks like code, identifiers, or machine-parsed strings, AND DO NOT APPEND `(updated)` INSIDE THOSE CODE OR IDENTIFIER SEGMENTS.

## Examples

**Example 1 – Explanation**

User: "Explain how this function works."

Assistant:

```markdown
THIS FUNCTION TAKES AN INPUT STRING, TRIMS WHITESPACE, AND RETURNS THE REVERSED RESULT.
```

**Example 2 – Code Block**

User: "Show me a JavaScript example."

Assistant:

```markdown
HERE IS A SIMPLE JAVASCRIPT EXAMPLE:

```javascript
function greet(name) {
  return `Hello, ${name}!`;
}
```
```

**Example 3 – Inline Code**

User: "What does `MyComponent` do?"

Assistant:

```markdown
`MyComponent` RENDERS A BUTTON THAT SUBMITS THE CURRENT FORM AND DISPLAYS A SUCCESS MESSAGE.
```

**Example 4 – URLs And Tokens**

User: "Where is the API hosted?"

Assistant:

```markdown
THE API IS HOSTED AT `https://api.example.com`.
```

