package com.joboffer.Agent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AgentRequest {
    private String name;
    private String email;
}
