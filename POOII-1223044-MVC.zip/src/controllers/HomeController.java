package controllers;

import core.Controller;
import views.EventListView;
import views.HomeView;
import views.NewEventView;
import views.RegisterGuestView;
import views.RemoveEventView;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller
{
    private final EventListController eventListController = new EventListController();
    private final NewEventController newEventController = new NewEventController(eventListController);

    //TODO
    private final RemoveEventController removeEventController = new RemoveEventController();
    private final RegisterGuestController registerGuestController = new RegisterGuestController();


    //-----------------------------------------------------------------------
    //		Methods
    //-----------------------------------------------------------------------
    @Override
    public void run()
    {
        // Initializes others controllers
        eventListController.run();
        newEventController.run();
        removeEventController.run();
        registerGuestController.run();

        // Initializes HomeView
        //-----------------------------------------------------------------------
        //		Attributes
        //-----------------------------------------------------------------------
        HomeView homeView = new HomeView(this, mainFrame);
        addView("HomeView", homeView);

        // Displays the program window
        mainFrame.setVisible(true);
    }


    //-----------------------------------------------------------------------
    //		Getters
    //-----------------------------------------------------------------------
    public EventListView getEventListView()
    {
        return eventListController.getView();
    }

    public NewEventView getNewEventView()
    {
        return newEventController.getView();
    }

    public RemoveEventView getRemoveEventView(){
        return removeEventController.getView();
    }
    
    public RegisterGuestView getRegisterGuestView() {
        return registerGuestController.getView();
    }

}
