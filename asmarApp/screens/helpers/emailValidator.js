export function emailValidator(email) {
    const re = /\S+@\S+\.\S+/
    if (!email) return "Email ne doit pas être vide."
    if (!re.test(email)) return 'Oops! email n\'est pas valide.'
    return ''
}