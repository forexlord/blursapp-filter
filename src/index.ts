// Reexport the native module. On web, it will be resolved to FilterModule.web.ts
// and on native platforms to FilterModule.ts
export { default } from './FilterModule';
export { default as FilterModuleView } from './FilterModuleView';
export * from  './FilterModule.types';
