# Copilot Instructions for learnings Repository

This is a multi-project repository containing learning experiments with different technologies and platforms.

## Repository Structure

The repository is organized into four independent sub-projects:

### 1. **ai_learnings/** - Container-based AI Infrastructure
- **Purpose**: N8N workflow automation integrated with Ollama (local LLM) and Solace messaging
- **Stack**: Docker, Docker Compose, N8N, Ollama, Solace PubSub+
- **Key Files**:
  - `docker-compose.yml` - Defines three services: N8N (automation), Ollama (AI models), Solace (message broker)
  - `.env` - Environment variables for N8N auth, API keys, and service configuration
  - `n8n-workflow-stock-analysis.json` - Example N8N workflow for stock analysis
  - `Dockerfile.ollama` - Custom Ollama image for AI model execution

### 2. **bruno_api_collections/** - Bruno API Collections
- **Purpose**: API testing collections for Bruno tool
- Contains: `brunoapi/` directory with collection configurations

### 3. **terraform_mutipass/** - Terraform Infrastructure
- **Purpose**: Infrastructure provisioning using Multipass (Ubuntu VMs) and Rancher Kubernetes
- **Stack**: Terraform, Multipass, Rancher 2
- **Key Files**:
  - `provider.tf` - Provider configuration (Multipass v1.4.1, Rancher2 v1.25.0)
  - `rancher_init.tf` - Bootstrap Rancher cluster and admin configuration
  - `rancher_cluster.tf` - Rancher cluster resource definitions
  - Cloud-init files for VM initialization (`rancher_ui_cloud_init_file.conf`, `rancher_cluster_cloud_init_file.conf`)

## Build, Test & Run Commands

### ai_learnings - Docker Services

**Start all services:**
```bash
cd ai_learnings
docker-compose up -d
```

**Stop services:**
```bash
cd ai_learnings
docker-compose down
```

**View service logs:**
```bash
# N8N
docker-compose logs -f n8n

# Ollama (AI model server)
docker-compose logs -f ollama

# Solace messaging
docker-compose logs -f solace
```

**Access services:**
- N8N UI: http://localhost:5678 (credentials in `.env`)
- Ollama API: http://localhost:11434
- Solace Web Console: http://localhost:8080

### terraform_mutipass - Terraform

**Initialize Terraform:**
```bash
cd terraform_mutipass
terraform init
```

**Plan infrastructure:**
```bash
terraform plan
```

**Apply infrastructure:**
```bash
terraform apply
```

**Destroy infrastructure:**
```bash
terraform destroy
```

## Key Conventions & Architecture Notes

### Environment Management (ai_learnings)
- **Sensitive data**: Store API keys and credentials in `.env` (not committed to git)
- **Default credentials**: N8N has basic auth enabled; update `N8N_BASIC_AUTH_USER` and `N8N_BASIC_AUTH_PASSWORD` before deployment
- **Service discovery**: Services communicate internally via service names (e.g., `http://ollama:11434`)

### Multipass + Terraform (terraform_mutipass)
- **Instance provisioning**: Multipass creates lightweight Ubuntu VMs; terraform manages lifecycle
- **Cloud-init**: VMs are initialized using cloud-init configuration files (`.conf` files)
- **Rancher bootstrap**: Two Rancher2 provider aliases used:
  - `bootstrap` provider: For initial admin setup
  - Default provider: For subsequent configuration
- **DNS**: Assumes DNS resolution for Rancher at `rancher.mutipass-instance.com`

### N8N Workflow (ai_learnings)
- **Workflow file**: `n8n-workflow-stock-analysis.json` is an example; workflows are typically managed through N8N UI
- **Ollama integration**: N8N connects to Ollama for LLM tasks via `OLLAMA_HOST` env variable
- **API keys**: Stock market data requires API key configuration (Alpha Vantage or Finnhub) in `.env`

## Important Notes

- Each sub-project is independent; changes in one do not affect others
- The `.env` file in ai_learnings contains default/placeholder credentials; update for production use
- Terraform state files are not committed; they're generated locally and should be managed with remote backends for team use
- Docker images (N8N, Ollama, Solace) are fetched from public registries
