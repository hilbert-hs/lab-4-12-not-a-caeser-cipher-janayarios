class Cipher {
  private String[][] letterBlock;
  private int numRows;
  private int numCols;

  // Constructor: parameters include number of rows, number of columns

  public Cipher(int r, int c) {
    this.numRows = r;
    this.numCols = c;
    this.letterBlock = new String[r][c];
  }


  // method fillBlock(): places a String into letterBlock in row major order
  // @param str: the String to be processed
  // POSTCONDITION: if str.length() < numRows * numCols, "A" is placed in each unfilled cell
  // POSTCONDITION: if str.length() > numRows * numCols, trailing characters are ignored

  public void fillBlock(String str) {
    int letterPosition = 0;
    for (int i = 0; i < numRows; i++) {
      
      for (int j = 0; j < numCols; j++) {
        if (letterPosition < str.length()) {
          letterBlock[i][j] = str.substring(letterPosition, letterPosition + 1);
          letterPosition++;
        }

        else {
          letterBlock[i][j] = "A";
        }

      }

    }
  }

  // method encryptBlock(): extracts encrypted message (cipher) from letterBlock in column major order
  // PRECONDITION: letterBlock has been filled
  // @return encrypted String from letterBlock

  private String encryptBlock() {
    String encryptedString = "";

    for (int i = 0; i < numCols; i++) {

      for (int j = 0; j < numRows; j++) {

        encryptedString += letterBlock[j][i];

      }

    }

    return encryptedString;

  }

  // method encryptMessage(): encrypts a message using methods fillBlock() and encryptBlock()
  // @param message: the String to be encrypted
  // @return the encrypted message
  // if message is an empty String, returns an empty string

  public String encryptMessage(String message) {
    fillBlock(message);
    encryptBlock();
    return encryptBlock();
  }
}
