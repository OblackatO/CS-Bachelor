package Filters;

import org.apache.pig.FilterFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import java.io.IOException;

public class FiltersPredicate extends FilterFunc {

    @Override
    public Boolean exec(Tuple tuple) throws IOException {
        if (tuple == null || tuple.size() == 0) {
            return false;
        }
        try {
            Object object_temp = tuple.get(1);
            Object object = tuple.get(1).equals("<hasGivenName>");
            if ((Boolean) object) {
                return  true;
            }else{
                return false;
            }
        } catch (ExecException e) {
            throw new IOException(e);
        }
    }
}
