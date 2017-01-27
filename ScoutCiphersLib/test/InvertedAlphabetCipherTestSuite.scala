import ciphers.InvertedAlphabetCipher
import org.scalatest.FunSuite

class InvertedAlphabetCipherTestSuite extends FunSuite {
  private val invertedAlphabetCipher = new InvertedAlphabetCipher()

  test("Characters in uppercase should be maintained in uppercase") {
    assertResult("SVOOL DLIOW") {
      invertedAlphabetCipher.encrypt("HELLO WORLD")
    }

    assertResult("HELLO WORLD") {
      invertedAlphabetCipher.decrypt("SVOOL DLIOW")
    }
  }

  test("Characters in downcase should be maintained in downcase") {
    assertResult("svool dliow") {
      invertedAlphabetCipher.encrypt("hello world")
    }

    assertResult("hello world") {
      invertedAlphabetCipher.decrypt("svool dliow")
    }
  }

  test("Non [A-Z][a-z] characters should be maintained as-is, without encryption") {
    assertResult("svool, dliow!") {
      invertedAlphabetCipher.encrypt("hello, world!")
    }

    assertResult("hello, world!") {
      invertedAlphabetCipher.decrypt("svool, dliow!")
    }
  }

  test("Special characters, if possible, should be transliterated") {
    assertResult("Loz nfmwl") {
      invertedAlphabetCipher.encrypt("Olá mundo")
    }

    assertResult("Ola mundo") {
      invertedAlphabetCipher.decrypt("Loz nfmwl")
    }
  }

}
