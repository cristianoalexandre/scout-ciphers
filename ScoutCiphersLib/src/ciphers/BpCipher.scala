package ciphers

class BpCipher extends Cipher {
  override def encrypt(text: String): String = {
    var encryptedText = ""

    var previousStringIsBP = false
    text.foreach(char =>
      if (!Character.isWhitespace(char)) {
        if (!previousStringIsBP) {
          encryptedText += "BP"
        }
        encryptedText += char + "BP"
        previousStringIsBP = true
      } else {
        encryptedText += char
        previousStringIsBP = false
      }

    )

    encryptedText
  }

  override def decrypt(text: String): String = {
    text.replace("BP", "")
  }
}
