import ciphers.BpCipher
import org.scalatest.FunSuite

class BpCipherTestSuite extends FunSuite {
  private val bpCipher = new BpCipher()

  test("BPs should be placed around each non-whitespace character when encrypting") {
    assertResult("BPHBPeBPlBPlBPoBP") {
      bpCipher.encrypt("Hello")
    }
  }

  test("Ensuring BPs are placed *ONLY* on non-whitespace characters") {
    assertResult("BPHBPiBP BPiBPtBP'BPsBP BPmBPeBP") {
      bpCipher.encrypt("Hi it's me")
    }

    assertResult("BPHBP BPTBP BPABP") {
      bpCipher.encrypt("H T A")
    }
  }

  test("Decoding must remove *all* BP characters") {
    assertResult("Hi") {
      bpCipher.decrypt("BPHBPiBP")
    }
  }

  test("Decoding must leave whitespace untouched") {
    assertResult("Hi it's me") {
      bpCipher.decrypt("BPHBPiBP BPiBPtBP'BPsBP BPmBPeBP")
    }

    assertResult("H  T A") {
      bpCipher.decrypt("BPHBP  BPTBP BPABP")
    }
  }

}
