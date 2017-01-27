package ciphers

import gcardone.junidecode.Junidecode

class InvertedAlphabetCipher extends Cipher {

  // 65 -> 90 (A -> Z)
  // 97 -> 122 (A -> Z)

  // A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z
  // Z,Y,X,W,V,U,T,S,R,Q,P,O,N,M,L,K,J,I,H,G,F,E,D,C,B,A

  override def encrypt(text: String): String = {
    var encryptedText = ""
    val transliteratedText = Junidecode.unidecode(text)

    transliteratedText.foreach(char => {
      if ('A' to 'Z' contains char) {
        encryptedText += ('Z' - (char - 'A')).toChar
      } else if ('a' to 'z' contains char) {
        encryptedText += ('z' - (char - 'a')).toChar
      } else {
        encryptedText += char
      }
    })

    encryptedText
  }

  override def decrypt(text: String): String = {
    encrypt(text)
  }
}
