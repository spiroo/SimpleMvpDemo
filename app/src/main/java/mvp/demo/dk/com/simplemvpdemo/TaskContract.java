package mvp.demo.dk.com.simplemvpdemo;

/**
 * Created by DK-dong on 2016/8/23.
 */

public interface TaskContract {

    interface View {

        void setLoadingIndicator(boolean active);

        void showMissingTask();

        void hideTitle();

        void showTitle(String title);

        void hideDescription();

        void showDescription(String description);

        void showCompletionStatus(boolean complete);

        void showEditTask(String taskId);

        void showTaskDeleted();

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        boolean isActive();
    }

    interface Presenter {

        void editTask();

        void deleteTask();

        void completeTask();

        void activateTask();
    }
}
