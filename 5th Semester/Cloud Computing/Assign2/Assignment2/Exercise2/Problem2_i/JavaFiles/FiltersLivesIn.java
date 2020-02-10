package Filters;

import org.apache.pig.FilterFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import java.io.IOException;

public class FiltersLivesIn extends FilterFunc {

    @Override
    public Boolean exec(Tuple tuple) throws IOException {
        if (tuple == null || tuple.size() == 0) {
            return false;
        }
        try {
            Object object = tuple.get(2);
            String object_str = (String) object;
            Object object_predicate = tuple.get(1);
            String predicate_str = (String) object_predicate;
            if(object_str.contains(",") && predicate_str.equals("<livesIn>")){
                return true;
            }else{
                return false;
            }
        } catch (ExecException e) {
            throw new IOException(e);
        }
    }
}