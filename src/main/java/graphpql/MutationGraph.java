package graphpql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import entities.Module.TypeModule;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class MutationGraph implements GraphQLRootResolver {

    private ModuleBusiness moduleRepo;
    private UniteEnseignementBusiness UERepo;

    public MutationGraph(ModuleBusiness moduleRepo, UniteEnseignementBusiness ueRepo) {
        this.moduleRepo = moduleRepo;
        this.UERepo = ueRepo;
    }

    public UniteEnseignement createUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        UERepo.addUniteEnseignement(ue);
        return ue;
    }

    public UniteEnseignement updateUniteEnseignement(int code, String domaine, String responsable, Integer credits, Integer semestre) {
        UniteEnseignement ue = UERepo.getUEByCode(code);
        if (ue != null) {
            if (domaine != null) ue.setDomaine(domaine);
            if (responsable != null) ue.setResponsable(responsable);
            if (credits != null) ue.setCredits(credits);
            if (semestre != null) ue.setSemestre(semestre);
            UERepo.updateUniteEnseignement(code, ue);
        }
        return ue;
    }

    public boolean deleteUniteEnseignement(int code) {
        return UERepo.deleteUniteEnseignement(code);
    }

    public Module createModule(String matricule, String nom, int coefficient, int volumeHoraire, TypeModule type, int codeUE) {
        Module m = new Module(matricule, nom, coefficient, volumeHoraire, type, UERepo.getUEByCode(codeUE));
        moduleRepo.addModule(m);
        return m;
    }

    public Module updateModule(String matricule, String nom, Integer coefficient, Integer volumeHoraire, TypeModule type, Integer codeUE) {
        Module m = moduleRepo.getModuleByMatricule(matricule);
        if (m != null) {
            if (nom != null) m.setNom(nom);
            if (coefficient != null) m.setCoefficient(coefficient);
            if (volumeHoraire != null) m.setVolumeHoraire(volumeHoraire);
            if (type != null) m.setType(type);
            if (codeUE != null) m.setUniteEnseignement(UERepo.getUEByCode(codeUE));
            moduleRepo.updateModule(matricule, m);
        }
        return m;
    }

    public boolean deleteModule(String matricule) {
        return moduleRepo.deleteModule(matricule);
    }


}

