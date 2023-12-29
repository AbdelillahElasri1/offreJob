package com.joboffer.Agent;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AgentResponse {
    private Long id;
    private String name;
    private String email;
}
