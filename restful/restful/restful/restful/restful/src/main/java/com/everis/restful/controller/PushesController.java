package com.everis.restful.controller;


import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.restful.model.Added;
import com.everis.restful.model.Commit;
import com.everis.restful.model.Modified;
import com.everis.restful.model.Project;
import com.everis.restful.model.Push;
import com.everis.restful.model.Removed;
import com.everis.restful.service.AddedService;
import com.everis.restful.service.CommitService;
import com.everis.restful.service.ModifiedService;
import com.everis.restful.service.ProjectService;
import com.everis.restful.service.PushService;
import com.everis.restful.service.RemovedService;
import com.everis.restful.service.RepositorioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RequestMapping(value="/api")
@Api(value="API Rest Eventos")
@CrossOrigin(origins="*")
@RestController
public class PushesController {
    // inicialização via injeção de dependencia Spring dos serviços para as entidades
	@Autowired private PushService pushService;
	@Autowired private CommitService commitService;
	@Autowired private ProjectService projetoService;
	@Autowired private RepositorioService repositorioService;
	@Autowired private AddedService addedService;
	@Autowired private ModifiedService modifiedService;
	@Autowired private RemovedService removedService;
	
	/*
	@PostMapping("/push/test")
	public ResponseEntity<Push> readAndSendPushTest(@RequestBody Push push) {
		//setInfoPushEntity(push,push);
		pushService.save(push);
		return new ResponseEntity<Push>(push,HttpStatus.OK);
	}
	*/
	
	@PostMapping("/event/push")
	@ApiOperation(value="Salva Envento")
	public ResponseEntity<Push> readAndSendPush(@RequestBody Push push) {
		// setar valores de utilidades (data atual)
		Timestamp dtIncl = new Timestamp(System.currentTimeMillis());
		
		// persistir a tupla Push
		push.setDtIncl(dtIncl);
		pushService.save(push);
		// persistir a tupla Project
		Project project = push.getProject();
		project.setPush(push);
		project.setDtIncl(dtIncl);
		projetoService.save(project);
		
		// persistir a tupla Repository
		push.getRepository().setPush(push);
		push.getRepository().setDtIncl(dtIncl);
		repositorioService.save(push.getRepository());
        // persistir tuplas commits
        for(Commit commit : push.getCommits()) {
            commit.setPush(push);
            commit.setDtIncl(dtIncl);    // ???
            commitService.save(commit);
            // persistir tuplas addeds
            for(String added : commit.getAddeds()){
            	Added add = new Added();
            	add.setCommit(commit);
            	add.setAdded(added);
            	add.setDtIncl(dtIncl);
            	commit.getAdded().add(add);
            	addedService.save(add);
            }
            // persistir tuplas modifieds
            for(String modified : commit.getModifieds()){
            	Modified mod = new Modified();
            	mod.setCommit(commit);
            	mod.setModified(modified);
            	mod.setDtIncl(dtIncl);
            	commit.getModified().add(mod);
            	modifiedService.save(mod);
            }
           // persistir tuplas removeds
            for(String removed : commit.getRemoveds()){
            	Removed rem = new Removed();
            	rem.setCommit(commit);
            	rem.setRemoved(removed);
            	rem.setDtIncl(dtIncl);
            	commit.getRemoved().add(rem);
            	removedService.save(rem);
            }
        }
		return new ResponseEntity<Push>(push,HttpStatus.OK);
	}

	
}
