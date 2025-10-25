package graphpql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import java.util.List;

public class QueryGraph implements GraphQLRootResolver {

    private ModuleBusiness moduleRepo;
    private UniteEnseignementBusiness UERepo;

    public QueryGraph(ModuleBusiness moduleRepo, UniteEnseignementBusiness ueRepo) {
        this.moduleRepo = moduleRepo;
        this.UERepo = ueRepo;
    }

    public List<Module> getAllModules() {
        return moduleRepo.getAllModules();
    }

    public Module getModuleByMatricule(String matricule) {
        return moduleRepo.getModuleByMatricule(matricule);
    }

    public List<Module> getModulesByUE(int codeUE) {
        return moduleRepo.getModulesByUE(UERepo.getUEByCode(codeUE));
    }

    public List<Module> getModulesByType(Module.TypeModule type) {
        return moduleRepo.getModulesByType(type);
    }

    public List<UniteEnseignement> getAllUnitesEnseignement() {
        return UERepo.getListeUE();
    }

    public UniteEnseignement getUEByCode(int code) {
        return UERepo.getUEByCode(code);
    }

    public List<UniteEnseignement> getUEByDomaine(String domaine) {
        return UERepo.getUEByDomaine(domaine);
    }

    public List<UniteEnseignement> getUEBySemestre(int semestre) {
        return UERepo.getUEBySemestre(semestre);
    }
}
