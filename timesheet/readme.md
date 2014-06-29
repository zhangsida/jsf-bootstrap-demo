Hello,

this application is a demo project, showing of the use of Spring, JSF and Bootstrap together.
To do this, we have extended the Spring scopes with a "view" scope, which you can find in the de.bit.spring.scope package.
Since this is a rather basic demo application, we forewent the classic MVC pattern for simplicity's sake. Instead most
of the logic is handled by the controllers, even persistence which should  ideally handled in the service layer.

The main page, index.xhtml, consists of two tabs. The tab controller holds the information which tab is currently active.
Only the active tab is renders. Clicking a tab will trigger an AJAX request which will repaint the tab contents. The content
of the tabs can be found in the dayView.xhtml and eventsOverviewView.xhtml files.
The dayView.xhtml shows all the events for a day. For the popup calendar the bootstrap-datepicker plugin is used. The events
fired by it, are caught with a <f:ajax event="change"/> tag.
The eventsOverView.xhtml implements pagination and shows all events.

In the main.less file you can tweak the css of the application. We used this a single colour layout, and by changing the 
@brand-primary variable, you can change the colour of the UI. The main.less file is compiled by maven and then placed in
in the src/main/webapp/resources/css directory.
Persistence is achieved by using Spring Data and Hibernate. The application sets up a H2 in memory database with some
prefilled data on startup.
For validation Bean Validation is used. To validate that the startTime is greater than the endTime, a custom JSF validator
is used(BeforeValidator).