package ir.technopedia.listadaptermultiview.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Cat extends Model {
    private String name, register;

    public Cat(String name, String register) {
        this.name = name;
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.getName()) &&
                Objects.equals(register, cat.getRegister());
    }

    public DiffUtil.ItemCallback<Cat> DIFF_CALLBACK = new DiffUtil.ItemCallback<Cat>() {
        @Override
        public boolean areItemsTheSame(@NonNull Cat oldItem, @NonNull Cat newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Cat oldItem, @NonNull Cat newItem) {
            return oldItem.equals(newItem);
        }
    };
}
