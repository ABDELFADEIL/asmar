export function passwordValidator(password) {
    if (!password) return "Password can't be empty."
    if (password.length < 4) return 'Le mot de passe doit être au moins 4 charactères.'
    return ''
}