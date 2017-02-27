package mco364;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegexTest {
    
    @Test
    public void findBob() {
        List<String> actual = Regex.findMatches("BOBBOB", "BOB");
        
        assertEquals(2, actual.size());
    }    
    
    @Test
    public void findWaldoCaseInsensitive() {
        List<String> actual = Regex.findMatches("Waldo walDOW WALDO", "(?i)waldo");// (?i)= ignore case
        
        assertEquals(3, actual.size());
    }
    
        
    @Test
    public void findCurrency() {
        List<String> actual = Regex.findMatches("6923749.02 475.10 ", "\\d+\\.\\d+");
        
        assertEquals(2, actual.size());
    }
           
    @Test
    public void findCurrency2() {
        List<String> actual = Regex.findMatches("45 0.45 .45 ", "([0]?)(\\.)?\\d+");
        
        assertEquals(3, actual.size());
    }
    
               
    @Test
    public void findCurrencyWithDollarSign() {
        List<String> actual = Regex.findMatches("$45 $0.45 $.45 ", "(\\$)([0]?)(\\.)?\\d+");
        
        assertEquals(3, actual.size());
    }
               
    @Test
    public void findProperNameWithFirstLetterCapitalized() {
        List<String> actual = Regex.findMatches("Bob Smithers John 23 yohann JJ j", "[A-Z][a-z]+");
        
        assertEquals(3, actual.size());
    }
    
                   
    @Test
    public void fintTelNumber() {
        List<String> actual = Regex.findMatches("555-1234 555.1234 987-3453 123-QWER ", "\\d{3}(\\.||-)\\d{4}");
        
        assertEquals(3, actual.size());
    }
                   
    @Test
    public void findMomAncestor() {
        List<String> actual = Regex.findMatches("mother grandmother greatgrandmother greatgreatgreatgreatgrandmother ", "^(mother)|(great)*(grandmother)");
        
        assertEquals(4, actual.size());
    }
    
                       
    @Test
    public void findScrabbleWord5LettersStartsWithM_AndEndsWithD() {
        List<String> actual = Regex.findMatches("MEAD MEND MOOD MUST", "[M][A-Z]{2}[D]");
        //you wrote 5 letters but your examples only have 4 letters. I wrote my
        //expression so that it only looks for 4 letters based on your assertion that 3 of them should are true
        //if you want 5 letters the syntax will simply be changed from [A-Z]{2} to [A-Z]{3}
        
        assertEquals(3, actual.size());
    }
}
