---
name: command-creator
description: Creates a new Gemini command, including the necessary directory and .toml file with a specified prompt. Use when you need to define a new, simple, prompt-based command.
---

# Command Creator

## Overview

This skill helps you create new Gemini commands. It automates the creation of the command's directory and the `.toml` configuration file.

## Workflow

This skill uses a script to create new commands. The process is as follows:

1.  **Get Command Details:** The agent will ask you for the new command's name, a description for it, and the prompt to execute.
2.  **Run Script:** The `scripts/create_command.py` script is executed with the provided details.
3.  **Verification:** The script creates the directory `.gemini/commands/<command-name>` and the file `.gemini/commands/<command-name>/<command-name>.toml` with the provided description and prompt.

## Resources

### scripts/

*   `create_command.py`: A Python script that takes a command name, description, and prompt to create the necessary command files.
