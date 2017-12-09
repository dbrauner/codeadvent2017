package day4;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by douglas on 09/12/2017.
 */
public class PassphraseValidatorTest {
    @Test
    public void validatePassphraseFile() throws Exception {

        PassphraseValidator validator = new PassphraseValidator();
        System.out.println(validator.validatePassphraseFile("src/test/resources/passphrases.txt"));
    }

    @Test
    public void validateAnagramPassphraseFile() throws IOException {
        PassphraseValidator validator = new PassphraseValidator();
        System.out.println(validator.validateAnagramPassphraseFile("src/test/resources/passphrases.txt"));
    }

}