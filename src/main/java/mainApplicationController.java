import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Mario on 2017-04-01.
 */
public class mainApplicationController implements Initializable{
    @FXML    ListView<String> arrayList;
    @FXML    WebView table;
    private WebEngine engine;
    List<String> values;
    List<String> content;

    public void initialize(URL location, ResourceBundle resources) {
        values = Repository.getValues();
        content = Repository.getTables();
        values.remove(values.size()-1);
        ObservableList<String> data= FXCollections.observableList(values);
        arrayList.setItems(data);
        engine = table.getEngine();
        engine.loadContent(content.get(0));
    }
    public void mouseClick(MouseEvent event){
        try {
            String target = event.getTarget().toString();
            for (int i = 0; i <= values.size(); i++) {
                if (target.contains(values.get(i))) {
                    engine.loadContent(content.get(i));
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
