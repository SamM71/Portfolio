import java.util.ArrayList;

public class ModuleCatalog {

    private ArrayList<Module> moduleList = new ArrayList<>();

    public ModuleCatalog() {

    }

    /*
    Determines if the module should be created.
    If it should, it is created and added to the catalogue.
     */
    public void addModule(int level, int code, String name, String deptCode) {
        if (checkCode(code) && checkLevel(level) && isDeptCodeValid(deptCode)) {
            Module newModule = new Module(level, code, name, deptCode);
            moduleList.add(newModule);
        }
    }

    /*
    Returns all modules in the catalogue.
     */
    public ArrayList getAllModules() {
        return moduleList;
    }

    /*
    Returns all modules in a specific level. Checks by using a for-each loop.
     */
    public ArrayList getModulesByLevel(int level) {
        Module moduleBeingChecked;
        ArrayList<Module> listByLevel = new ArrayList<>();
        for (Module module : moduleList) {
            moduleBeingChecked = module;
            if (level == moduleBeingChecked.getLevel()) {
                listByLevel.add(moduleBeingChecked);
            }
        }
        return listByLevel;
    }

    /*
    Returns all modules with a specific department code. Uses a for-each loop.
     */
    public ArrayList getModulesByDeptCode(String deptCode) {
        Module moduleBeingChecked;
        ArrayList<Module> listByDeptCode = new ArrayList<>();
        for (int i = 0; i < moduleList.size(); i++) {
            moduleBeingChecked = moduleList.get(i);
            if (deptCode == moduleBeingChecked.getDeptCode()) {
                listByDeptCode.add(moduleBeingChecked);
            }
        }
        return listByDeptCode;
    }

    /*
    Formats the output string and returns it.
     */
    public String formatCatalogList(ArrayList<Module> list) {
        String formattedCatalogList = "";

        for (Module newModule : list) {
            formattedCatalogList += newModule.toString() +"\n";
        }
        return formattedCatalogList;
    }

    /*
    Checks if the level is valid (between 3 and 6 inclusive).
     */
    public boolean checkLevel(int level) {
        final int minLevel = 3;
        final int maxLevel = 6;
        return level >= minLevel && level <= maxLevel;
    }

    /*
    Checks if the module code is valid (is unique and between 100 and 999 inclusive).
     */
    public boolean checkCode(int code) {
        Module moduleBeingChecked;
        for (int i = 0; i < moduleList.size(); i++) {
            moduleBeingChecked = moduleList.get(i);
            if (code == moduleBeingChecked.getCode()) {
                return false;
            }
        }
        final int min = 100;
        final int max = 999;
        return code >= min && code <= max;
    }

    /*
    Checks if the department code is valid.
     */
    public boolean isDeptCodeValid(String deptCode) {
        return deptCode == "CS" || deptCode == "MA";
    }
}
