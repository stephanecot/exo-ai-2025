import sys
from pathlib import Path

def create_command(command_name, description, prompt):
    """
    Creates a new Gemini command.

    Args:
        command_name: The name of the command.
        description: The description of the command.
        prompt: The prompt for the command.
    """
    commands_dir = Path(".gemini/commands")
    command_dir = commands_dir / command_name
    command_dir.mkdir(parents=True, exist_ok=True)

    toml_path = command_dir / f"{command_name}.toml"
    content = f'''description = "{description}"
prompt = """
{prompt}
"""
'''
    toml_path.write_text(content, encoding="utf-8")
    print(f"✅ Command '{command_name}' created at {toml_path}")

if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: python create_command.py <command_name> <description> <prompt>")
        sys.exit(1)

    command_name_arg = sys.argv[1]
    description_arg = sys.argv[2]
    prompt_arg = sys.argv[3]
    create_command(command_name_arg, description_arg, prompt_arg)
