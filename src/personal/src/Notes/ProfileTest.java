package personal.src.Notes;

public class ProfileTest {
    public static void main(String[] args) {

        // Profile profile1 = new Profile();            --> constructor private oldugu icin bu sekilde nesne obje olusturamiyoruz, bunu engelledik
        // Profile profile2 = new Profile();
        // Profile profile3 = new Profile();


        Profile profile = Profile.newInstance();
        profile.setCounter(1);

        Profile profile2 = Profile.newInstance();
        profile2.setCounter(1);

        Profile profile3 = Profile.newInstance();
        profile3.setCounter(1);

        System.out.println(profile.getCounter());
        System.out.println(profile2.getCounter());
        System.out.println(profile3.getCounter());


    }
}
