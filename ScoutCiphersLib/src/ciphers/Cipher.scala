package ciphers

trait Cipher {
  def encrypt(text: String): String

  def decrypt(text: String): String
}
