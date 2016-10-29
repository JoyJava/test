import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class CompletableFutureExample {

    public static class UserName {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class UserPhone {
        private String phone;

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }
    }

    public static void main(String[] args) throws Exception {

        CompletableFuture<UserName> userName = CompletableFuture.supplyAsync(() ->
                {
                    System.out.println("Creating name " + Thread.currentThread().getId());
                    return new UserName();
                }
        ).thenComposeAsync((UserName name) -> CompletableFuture.supplyAsync(() ->
                {
                    try {
                        Thread.sleep(10000); // sleep to show async behavior

                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Populating name " + Thread.currentThread().getId());
                    name.setName("Bill");
                    return name;
                }
        ));

        CompletableFuture<UserPhone> userPhone = CompletableFuture.supplyAsync(() ->
                {
                    System.out.println("Creating phone " + Thread.currentThread().getId());
                    return new UserPhone();
                }
        ).thenComposeAsync((UserPhone phone) -> CompletableFuture.supplyAsync(() ->
                {
                    System.out.println("Populating phone " + Thread.currentThread().getId());
                    phone.setPhone("800-000-1234");
                    return phone;
                }
        ));

        UserName name = userName.get(15000, TimeUnit.MILLISECONDS);
        UserPhone phone = userPhone.get();

        System.out.println("Done! name: " + name.getName() + " phone: " + phone.getPhone() + " " + Thread.currentThread().getId());
    }


}