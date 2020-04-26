package ir.technopedia.listadaptermultiview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ir.technopedia.listadaptermultiview.model.Cat;
import ir.technopedia.listadaptermultiview.model.Person;

public class ModelItemDiffCallback extends DiffUtil.ItemCallback {

    public ModelItemDiffCallback() {
    }

    @Override
    public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        if (oldItem instanceof Cat && newItem instanceof Person)
            return false;
        else if (oldItem instanceof Cat && newItem instanceof Cat) {

            if (oldItem.equals(newItem)) {
                return true;
            }
        } else if (oldItem instanceof Person && newItem instanceof Person) {
            if (oldItem.equals(newItem)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        return false;
    }
}