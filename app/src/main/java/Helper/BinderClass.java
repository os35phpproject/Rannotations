package Helper;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;

/**
 * Created by Alaa on 7/15/2018.
 */

public class BinderClass {
    Context context;
    public BinderClass(Context context){
        this.context = context;
    }
    public void bind(){
        for(Field field : context.getClass().getFields()) {
            if(context.getClass().getAnnotation(Binder.class).binder().equalsIgnoreCase("") || field.getName().toString().startsWith(context.getClass().getAnnotation(Binder.class).binder())){
                int resID = context.getResources().getIdentifier(field.getName().substring(context.getClass().getAnnotation(Binder.class).binder().length()), "id", context.getPackageName());
                View view = ((Activity)context).findViewById(resID);
                try {
                    field.set(context,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Log.i("BinderClass",field.getName()+" : "+ field.getType().toString());
            }
        }
    }
}
