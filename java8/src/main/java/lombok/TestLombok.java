package lombok;

/**
 * User: fh
 * Date: 16/10/26 下午2:24
 */
public class TestLombok {
    public static void main(String[] args) {

        User a = User.builder()
                .name("name")
                .code("code")
                .age(100)
                .build();
        System.out.println(a);

    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private String code;
    private int age;
}
