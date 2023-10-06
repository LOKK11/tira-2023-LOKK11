package oy.interact.tira.student;
import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {
    
    @Override
    public int compare(Coder first, Coder second) {
        if (first.getLastName().compareTo(second.getLastName()) == 0) {
			return first.getFirstName().compareTo(second.getFirstName());
		}
		return first.getLastName().compareTo(second.getLastName());
    }
}
