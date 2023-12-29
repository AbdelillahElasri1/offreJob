package com.joboffer.Agent;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agent")
public class AgentController {
    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<AgentRequest> createAgent(AgentRequest agentRequest){
        AgentRequest savedAgent = agentService.createAgent(agentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAgent);
    }
    @GetMapping
    public ResponseEntity<List<AgentResponse>> getAllAgents(){
        List<AgentResponse> responseList = agentService.getAllAgent();
        return ResponseEntity.ok(responseList);
    }
    @GetMapping("{id}")
    public ResponseEntity<AgentResponse> findAgentById(@PathVariable Long id){
        AgentResponse response = agentService.getAgentById(id);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("{id}")
    public void deleteAgent(@PathVariable Long id){
        agentService.deleteAgent(id);
    }
}
