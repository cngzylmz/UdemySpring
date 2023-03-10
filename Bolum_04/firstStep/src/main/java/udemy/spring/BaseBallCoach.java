package udemy.spring;

public class BaseBallCoach implements Coach {
    @Override
    public String getDailyWorkout(){
        return "run kido run";
    }
}
