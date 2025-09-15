package Utilities;

import lombok.Data;
import java.util.List;

@Data
public class TestData {
    private String email, pass, country;
    private List<String> products;

}
