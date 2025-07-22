terraform {
  required_providers {
    multipass = {
      source = "larstobi/multipass"
      version = "1.4.1"
    }
    rancher2 = {
      source = "rancher/rancher2"
      version = "1.25.0"
    }
  }
}


provider "multipass" {
  # Configuration options
}