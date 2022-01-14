package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryRoomService {
	
	@Autowired
	RecoveryRoomRepository repo;
	
    public List<RecoveryRoom> getAll(){
        return repo.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return repo.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return repo.getRecoveryRoomType(typeName);
    }

    public List<RecoveryRoom> getRecoveryRoomsBiggerThan(double size) {
        return repo.findBySizeMoreThan(size);
    }

    public RecoveryRoom save(RecoveryRoom p) {
        return repo.save(p);       
    }

    
}
