package mvp.demo.dk.com.simplemvpdemo.data;

import java.util.ArrayList;

/**
 * Created by DK-dong on 2016/8/23.
 * 电脑生产工厂类
 */

public class ComputerFactory {

    private ArrayList<Computer> computers = new ArrayList<>();

    public ArrayList<Computer> getComputers() {
        return computers;
    }

    public void setComputers(ArrayList<Computer> computers) {
        this.computers = computers;
    }

    public void addComputer(Computer computer){
        computers.add(computer);
    }

    public void removeComputer(int index){
        if (index >= 0 && index < computers.size()){
            computers.remove(index);
        }
    }

    public int getComputerCounts(){
        return computers.size();
    }

}
