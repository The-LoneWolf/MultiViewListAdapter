package ir.technopedia.listadaptermultiview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import ir.technopedia.listadaptermultiview.ModelItemDiffCallback;
import ir.technopedia.listadaptermultiview.R;
import ir.technopedia.listadaptermultiview.model.Cat;
import ir.technopedia.listadaptermultiview.model.Model;
import ir.technopedia.listadaptermultiview.model.Person;

public class MultiTypeAdapter extends ListAdapter<Model, RecyclerView.ViewHolder> {

    public MultiTypeAdapter() {
        super(new ModelItemDiffCallback());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.person_list_row, parent, false);
        vh = new PersonViewHolder(view);

        if (viewType == 1) {
            view = layoutInflater.inflate(R.layout.cat_list_row, parent, false);
            vh = new CatViewHolder(view);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Model obj = getItem(position);
        if (obj != null) {
            if (obj instanceof Cat) {
                ((CatViewHolder) holder).bindTo(obj);
            } else if (obj instanceof Person) {
                ((PersonViewHolder) holder).bindTo(obj);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof Person) {
            return 0;
        } else {
            return 1;
        }
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView register;

        CatViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            register = view.findViewById(R.id.register);
        }

        void bindTo(Model obj) {
            Cat cat = (Cat) obj;
            name.setText(cat.getName());
            register.setText(cat.getRegister());
        }
    }

    static class PersonViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView lastname;

        PersonViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            lastname = view.findViewById(R.id.lastname);
        }

        void bindTo(Model obj) {
            Person person = (Person) obj;
            name.setText(person.getName());
            lastname.setText(person.getLastName());
        }
    }
}

