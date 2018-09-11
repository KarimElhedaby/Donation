package donation.solutions.hamza.com.donation.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("all")
public class AcceptedProjects {
    private final List<Object> doner;

    private final String status;

    private final List<String> img;

    private final String creationDate;

    @SerializedName("_id")
    private final String id;

    private final String title;

    private final String desc;

    private final User user;

    private final int v;

    private final boolean going;

    public AcceptedProjects(List<Object> doner, String status, List<String> img,
                            String creationDate, String id, String title, String desc, User user, int v,
                            boolean going) {
        this.doner = doner;
        this.status = status;
        this.img = img;
        this.creationDate = creationDate;
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.user = user;
        this.v = v;
        this.going = going;
    }

    public List<Object> getDoner() {
        return doner;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getImg() {
        return img;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public User getUser() {
        return user;
    }

    public int getV() {
        return v;
    }

    public boolean isGoing() {
        return going;
    }

    public static class User {
        private final String type;

        private final String img;

        private final String creationDate;

        private final String id;

        private final String name;

        private final String phone;

        private final String email;

        private final String password;

        private final String gender;

        private final int v;

        public User(String type, String img, String creationDate, String id, String name,
                    String phone, String email, String password, String gender, int v) {
            this.type = type;
            this.img = img;
            this.creationDate = creationDate;
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.password = password;
            this.gender = gender;
            this.v = v;
        }

        public String getType() {
            return type;
        }

        public String getImg() {
            return img;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public String getGender() {
            return gender;
        }

        public int getV() {
            return v;
        }
    }
}
